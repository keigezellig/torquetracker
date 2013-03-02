package com.joco.trackerservice.rabbitmq;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

class RabbitMQHelper 
{
	/**
	 * Base class for objects that connect to a RabbitMQ Broker
	 */
	
		  private String serverName;
	      private String exchangeName;

	      private Channel channel = null;
	      private Connection connection;

	      private String exchangeType ;

	      /**
	       *
	       * @param server The server address
	       * @param exchange The named exchange
	       * @param exchangeType The exchange type name
	       */
	      public RabbitMQHelper(String server, String exchange, String exchangeType)
	      {
	    	  this.serverName = server;
	    	  this.exchangeName = exchange;
	    	  this.exchangeType = exchangeType;
	      }
	      
	      public void sendMessage(String key, String message) throws IOException
	      {
	      	if (connectToRabbitMQ())
	      	{
	      		System.out.println(key + "" + message);
	      		byte[] toBeTransmitted = message.getBytes("UTF8");
	      		channel.basicPublish(this.exchangeName, key, null, toBeTransmitted);
	      	}
	    	  
	      }

	      public void close()
	      {
	          
				try {
					if (this.connection!=null)
					{
						this.connection.close();
					}
					if (this.channel != null)
					{
						this.channel.abort();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	      }

	      /**
	       * Connect to the broker and create the exchange
	       * @return success
	       */
	      private boolean connectToRabbitMQ()
	      {
	    	  if(channel!= null && channel.isOpen() )//already declared
	    	  {
	    		  return true;
	    	  }
	    	  
	          try
	          {
	        	  ConnectionFactory connectionFactory = new ConnectionFactory();
	              connectionFactory.setHost(serverName);
	              connection = connectionFactory.newConnection();
	              channel = connection.createChannel();
	              channel.exchangeDeclare(exchangeName, exchangeType, true);

	              return true;
	          }
	          catch (Exception e)
	          {
	        	  e.printStackTrace();
	              return false;
	          }
	      }
	}



