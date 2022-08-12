package firstmodel;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.routing.*;
import com.anylogic.engine.presentation.*;
import com.anylogic.engine.gui.*;

import com.anylogic.libraries.modules.markup_descriptors.*;
import com.anylogic.libraries.fluid.*;
import com.anylogic.libraries.processmodeling.*;

import static com.anylogic.engine.Utilities.*;

/**
 * SocketOut
 */	
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedWriter;

public class SocketOut implements Serializable {

	static ServerSocket serverSocket = null; 
	static Socket clientSocket = null;

	 int PortName = 0;

    /**
     * Default constructor
     * @throws IOException
     */
    public SocketOut() throws IOException {
    	PortName = 4447;
    	serverSocket = new ServerSocket(PortName);
    	clientSocket = serverSocket.accept();

    }


	@Override
	public String toString() {
		return  "SocketId = " + clientSocket.toString() +" " +	"PortName = " + PortName +" ";
	}

	
	public static void WriteOut(int i) throws IOException {
		
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())); 
		wr.write(i);
		wr.flush(); // flushes the stream
	}
	
	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++)
		{
			WriteOut(i);
		}
	}
} 
