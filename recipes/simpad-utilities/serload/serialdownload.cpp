//=============================================================================
// Project:      SIMpad
//=============================================================================
// FILE-NAME:    serialdownload.cpp
// FUNCTION:     Serial download of a new image from PC to SIMpad
//
// AUTHOR:       Juergen Messerer, Peter Voser
// CREAT.-DATE:  01.04.2001 (dd.mm.yy)
//
// NOTES:        -
//
//=============================================================================

#include <iostream>
#include "serialdownload.h"
using namespace std;

//=============================================================================
//=============================================================================
SerialDownload::SerialDownload()
{
}

//=============================================================================
//=============================================================================
SerialDownload::~SerialDownload()
{
}

//=============================================================================
//=============================================================================
int SerialDownload::openSerialPort(const char* portDev, int& errorNumber)
{
    _serialPort = open(portDev, O_RDWR | O_NONBLOCK);

    if (_serialPort == -1)
    {
        errorNumber = errno;
        return -1;
    }

    // Read old serial port setup
    termios serialPortSetup;
    int success = tcgetattr(_serialPort, &serialPortSetup );     
    if (success < 0) 
    {
        errorNumber = errno;
        perror(0);
        return -1;
    }

    serialPortSetup.c_iflag = 0L;
    serialPortSetup.c_oflag = 0L;

    // Control mode flags
    serialPortSetup.c_cflag &= ~(CSTOPB|PARENB|CRTSCTS);
    serialPortSetup.c_cflag |= (CS8|CLOCAL);

    // Local mode flags
    serialPortSetup.c_lflag = 0L;

    // control characters
    serialPortSetup.c_cc[VTIME] = 0;
    serialPortSetup.c_cc[VMIN] = 0;

    // Set baud rate = 38.4kBaud
    cfsetispeed(&serialPortSetup, B38400);
    cfsetospeed(&serialPortSetup, B38400);

    success=tcsetattr(_serialPort, TCSANOW, &serialPortSetup);
    if(success < 0)
    {
        errorNumber = errno;
        perror(0);
        return -1;
    }

    return 0;
}

//=============================================================================
//=============================================================================
int SerialDownload::loadFile(const char *fileName, 
                             char *&buffer, 
                             int &numberOfBytes)
{
    FILE *path;

    if((path = fopen(fileName,"rb")) == 0)
    {
        // Specified file not found.
        return -1;
    }

    fseek(path, 0, 2);
    numberOfBytes = ftell(path);
    rewind(path);

    buffer = (char*)malloc((size_t)numberOfBytes);
    if(buffer == 0)
    {
        // Insufficient memory to load file.
        fclose(path);
        return -2;
    }

    if(fread(buffer, numberOfBytes, 1, path) != 1)
    {
        // Cannot read file.
        fclose(path);
        return -3;
    }

    fclose(path);
    return 0;
}

//=============================================================================
//=============================================================================
bool SerialDownload::changeBaudRate(const int newBaudRate, 
                                    int& errorNumber)
{
    int success;
    int baudRate;
    struct termios setup;

    switch(newBaudRate)
    {
    case 9600:
        baudRate = B9600;
        break;
    case 19200:
        baudRate = B19200;
        break;
    case 38400:
        baudRate = B38400;
        break;
    case 57600:
        baudRate = B57600;
        break;
    case 115200:
        baudRate = B115200;
        break;
    case 230400:
        baudRate = B230400;
        break;
    case 460800:
        baudRate = B460800;
        break;
    default:
        return 0;
        break;
    }

    success = tcgetattr(_serialPort, &setup);
    if (success < 0)
    {
        errorNumber = errno;
        perror(0);
        return 0;
    }

    cfsetispeed(&setup, baudRate);
    cfsetospeed(&setup, baudRate);
    success = tcsetattr(_serialPort, TCSANOW, &setup);
    if (success < 0) 
    {
        errorNumber = errno;
        perror(0);
        return 0;
    }

    return 1;
}

//=============================================================================
//=============================================================================
unsigned char SerialDownload::waitForReply(const int transparent)
{
    unsigned char c(0);
    int numberBytes(0);
    int reply(0);

    struct pollfd commEvent;
    commEvent.fd = _serialPort;
    commEvent.events = POLLIN;

    for(;;)
    {
        // Wait until a character has received.
        do
	{
            reply = poll(&commEvent, 1, 1000);
	}
        while(reply == 0);

        if(commEvent.revents == POLLIN)
        {
            do
	    {
	        numberBytes=read(_serialPort, &c, 1);
	        if(transparent && numberBytes)
	        {
	            cout << c;
                    cout.flush();
                }
                if((c == STX) || 
                   (c == ETX) || 
                   (c == BEL) || 
                   (c == ACK_OK) || 
                   (c == ACK_NOK))
                {
                    return c;
                }
            }
            while(numberBytes);
        }
    }
    return 0;
}

//=============================================================================
//=============================================================================
int SerialDownload::connectToSimpad(const int fastBaudRate, 
                                    int& errorNumber)
{
    errorNumber = 0;
    int bytesWritten;
    unsigned char c;

    // Switch baud rate to low connecting baud rate.
    if(!changeBaudRate(38400, errorNumber))
    {
        return -1;
    }

    // Wait for character STX (02) and BEL (07)
    while(waitForReply(1) != STX);
    while(waitForReply(1) != BEL);
    bytesWritten = write(_serialPort, &ACK_BD, 1);
    if(!bytesWritten)
    {
        errorNumber = errno;
        return -2;
    }

    // Send byte #2 of baud rate
    c = (fastBaudRate>>16)&0xff;
    bytesWritten = write(_serialPort, &c, 1);
    if(!bytesWritten)
    {
        errorNumber = errno;
        return -2;
    }

    // Send byte #1 of baud rate
    c = (fastBaudRate>>8)&0xff;
    bytesWritten = write(_serialPort, &c, 1);
    if(!bytesWritten)
    {
        errorNumber = errno;
        return -2;
    }

    // Send byte #0 of baud rate
    c = fastBaudRate&0xff;
    bytesWritten = write(_serialPort, &c, 1);
    if(!bytesWritten)
    {
        errorNumber = errno;
        return -2;
    }

    c = waitForReply(1);
    if (c == ACK_OK)
    {
        // Switch baud rate to fast baud rate.
        if(!changeBaudRate(fastBaudRate, errorNumber))
        {
	    return -3;
        }
    }

    // Wait for 1st character with new baud rate.
    while(waitForReply(1) != STX);

    bytesWritten = write(_serialPort, &STX, 1);
    if(!bytesWritten)
    {
        errorNumber = errno;
        return -4;
    }

    while(waitForReply(1) != STX);
    return 0;
}

//=============================================================================
//=============================================================================
bool SerialDownload::sendBlock(const char *buffer, 
                               const int length, 
                               int& errorNumber)
{
    errorNumber = 0;
    unsigned char c, check=0xff;
    int i;
    int bytesWritten;

    while(1)
    {
        if(length == 512)
        {
	    // It's a complete block.
	    bytesWritten = write(_serialPort, buffer, 512);
	    if(!bytesWritten)
	    {
	        errorNumber = errno;
	        return 0;
	    }
            // Create checksum.
            for(i = 0; i < 512; ++i)
            {
                check=(check<<1) ^ buffer[i];
            }
        }
        else
        {
            // It's an incomplete block, which must be filled with 
	    // the FILLER pattern. 
	    char lastBlock[512];
	    for(i = 0; i < 512; ++i)
	    {
	        if(i < length)
	        {
	            // Create checksum.
	            check=(check<<1) ^ buffer[i];
	            lastBlock[i] = buffer[i];
	        }
                else
	        {
                    // Create checksum
                    check=(check<<1) ^ FILLER;
                    lastBlock[i] = FILLER;
                }
            }
            bytesWritten = write(_serialPort, lastBlock, 512);
            if(!bytesWritten)
            {
                errorNumber = errno;
                return 0;
            }
        }

        while(waitForReply(1) != STX);

        if(length == 512)
        {
            bytesWritten = write(_serialPort, &STX, 1);
            if(!bytesWritten)
            {
                errorNumber = errno;
                return 0;
            }
        }
        else
        {
            // It was the last block.
            bytesWritten = write(_serialPort, &ETX, 1);
            if(!bytesWritten)
            {
                errorNumber = errno;
                return 0;
            }
        }

        // Send checksum. 
        bytesWritten = write(_serialPort, &check, 1);
        if(!bytesWritten)
        {
            errorNumber = errno;
            return 0;
        }

        // Wait for ACK_OK as confirmation. Send block again otherwise. 
        c = waitForReply(1);
        if(c == ACK_OK)
        {
            // The block was successfully sent.
            return 1;
        }
    }
}

//=============================================================================
//=============================================================================
void SerialDownload::waitForEndOfBurning(void)
{
    // Wait for ETX, which indicates the end of burning.
    while(waitForReply(1) != ETX);

    // Send the characters "r" (erase registry) and "o" (power off).
    char c = 'r';
    int bytesWritten;
    bytesWritten = write(_serialPort, &c, 1);
    c = 'o';
    bytesWritten = write(_serialPort, &c, 1);
    usleep(7000);
}
