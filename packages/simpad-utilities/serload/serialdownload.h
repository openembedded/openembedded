//=============================================================================
// Project:      SIMpad
//=============================================================================
// FILE-NAME:    serialdownload.hpp
// FUNCTION:     Serial download interface.
//
// AUTHOR:       Juergen Messerer, Peter Voser
// CREAT.-DATE:  01.04.2001 (dd.mm.yy)
//
// NOTES:        -
//               
//=============================================================================

#ifndef __SERIAL_DOWNLOAD
#define __SERIAL_DOWNLOAD

#include <errno.h> 
#include <fcntl.h>
#include <poll.h>
#include <stdio.h>
#include <stdlib.h>
#include <termios.h>
#include <unistd.h>

const unsigned char STX     = 2;
const unsigned char ETX     = 3;
const unsigned char BEL     = 7;
const unsigned char ACK_BD  = 11;
const unsigned char ACK_OK  = 6;
const unsigned char ACK_NOK = 15;
const unsigned char FILLER  = 0xff;

class SerialDownload
{
public:
  SerialDownload();
  ~SerialDownload();
//=============================================================================
//  PURPOSE:      Opening a serial port.
//
//  PARAMETERS: 
//                portDev: (IN) port device to open.
//                errorNumber: (OUT) error number determined with 
//                             GetLastError().
//  RETURN VALUE: 
//                serialPort: Filedescriptor of opened serial port. 
//                If the function fails, it returns -1. 
//
//  COMMENTS:     -
//=============================================================================
  int openSerialPort(const char* portDev, int &errorNumber);
  
//=============================================================================
//  PURPOSE:      Loading file with a image 
//
//  PARAMETERS: 
//                fileName: (IN) name of file to open
//                buffer: (OUT) pointer to loaded image file.
//                numberOfBytes: (OUT) size of file.
//
//  RETURN VALUE: 
//                 0: success
//                -1: specified file not found
//                -2: not enough memory to load file
//                -3: cannot read file
//
//  COMMENTS:     -
//=============================================================================
  int loadFile(const char *fileName, char *&buffer, int &numberOfBytes);

//=============================================================================
//  PURPOSE:      Connecting to the SIMpad.
//
//  PARAMETERS:
//                fastBaudRate: (IN) value of fast baud rate. 
//                errorNumber: (OUT) error number errno
//
//  RETURN VALUE: 
//                0: success
//               -1: switching to connection baud rate 38400baud failed. 
//               -2: writing to serial port failed. 
//               -3: switching to fast baud rate failed. 
//               -4: writing to serial port with fast baud rate failed. 
//
//  COMMENTS:     The connection is set up according to the bootloader's 
//                serial download protocoll.
//=============================================================================
  int connectToSimpad(const int fastBaudRate, 
		      int& errorNumber);

//=============================================================================
//  PURPOSE:      Sending a block of 512byte.
//
//  PARAMETERS: 
//                b: (IN) pointer to the beginning of the 512byte buffer.
//                len: (IN) length of the buffer.
//                errorNumber: (OUT) error number determined with 
//                             GetLastError().
//  RETURN VALUE: 
//                TRUE: success
//                FALSE: error. See errorNumber for the reason.
//
//  COMMENTS:     The block, which is sent, is always 512byte long. If the 
//                buffer counts less than 512byte, the block is filled with 
//                the FILLER pattern. 
//=============================================================================
  bool sendBlock(const char *b, 
                 const int len,  
	         int& errorNumber);

//=============================================================================
//  PURPOSE:      Waiting for the end of burning.
//
//  PARAMETERS:   -
//
//  RETURN VALUE: -
//
//  COMMENTS:     -
//=============================================================================
  void waitForEndOfBurning(void);

private:
  // File descriptor of open serial port.
  int _serialPort;

//=============================================================================
//  PURPOSE:      Changing baud rate.
//
//  PARAMETERS:
//                newBaudRate: (IN) new baud rate to switch to.
//                errorNumber: (OUT) error number determined with 
//                             GetLastError().
//
//  RETURN VALUE: 
//                TRUE: success
//                FALSE: error. See errorNumber for the reason.
//
//  serialMENTS:     -
//=============================================================================
  bool changeBaudRate(const int newBaudRate, 
                      int &errorNumber);

//=============================================================================
//  PURPOSE:      Waiting for control character.
//
//  PARAMETERS: 
//                transparent: (IN) 0 = received characters are sent to 
//                                  stdout.
//
//  RETURN VALUE: 
//                c: control character.
//
//  COMMENTS:     -
//=============================================================================
  unsigned char waitForReply(const int transparent);

};
#endif // __SERIAL_DOWNLOAD 
