#include "TheSocket.h"
#include "io.h"
#include <Ws2tcpip.h>

TheSocket::TheSocket(){}

TheSocket::~TheSocket(){}

int TheSocket::main()
{
    int sock = 0, valread, client_fd;
    struct sockaddr_in serv_addr;
    String hello = "Hello from client";
    char buffer[1024] = { 0 };
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0) {
        printf("\n Socket creation error \n");
        return -1;
    }

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(80);

    // Convert IPv4 and IPv6 addresses from text to binary
    // form
    if (InetPton(AF_INET, "127.0.0.1", &serv_addr.sin_addr)
        <= 0) {
        printf(
            "\nInvalid address/ Address not supported \n");
        return -1;
    }

    if ((client_fd
        = connect(sock, (struct sockaddr*)&serv_addr,
            sizeof(serv_addr)))
        < 0) {
        printf("\nConnection Failed \n");
        return -1;
    }
	for(int i = 0; i < 50; i++)
	{
		valread = read(sock, buffer, 1024);
		printf("%s\n", buffer);
	}

    // closing the connected socket
    close(client_fd);
    return 0;
}