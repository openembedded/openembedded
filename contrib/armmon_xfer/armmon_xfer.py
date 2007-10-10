#!/usr/bin/python

# Small utility to upload kernel and/or ramdisk to
# the compulab board through the ARMmon firmware.
# Requires pyserial : http://pyserial.sourceforge.net
# author: Tobias Pflug

import sys, os, serial, getopt, atexit, re

# regular expression to match valid IPv4 addresses
ipv4_regex = r"\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\b"

def wait_flash_complete():
    while 1:
        data = s.readline()
        if quiet != 1:
            print data,
        if data.split(" ")[0] == "Finished":
            break

def test_armmon():
    # write some nonsense to the monitor and
    # check if armmon replies accordingly
    s.write("nonsense\n")
    s.timeout=2
    s.read(len("nonsense\n")+1)
    data = s.read(len("Illegal"))
    if data.split(" ")[0] != "Illegal":
        sys.exit("Error: ARMmon not responding. Linux running maybe?")
    s.timeout=None
    s.flushInput()
    s.flushOutput()


def usage():
    sys.stderr.write("""USAGE: %s [options] <server ip>
    armmon_xfer - data upload tool for cmx270/ARMmon

    options:
    -p, --port=PORT:        serial port, default='/dev/ttyUSB0'
    -k, --kernel=KERNEL:    upload and flash kernel image KERNEL
    -r, --ramdisk=RAMDISK:  upload and flash ramdisk image RAMDISK
    -b, --bootos:           boot Linux
    -R, --reboot:           reboot cmx270
    -q, --quiet             be quiet, little output
    -h, --help:             print this help screen

""" % (sys.argv[0],))

if __name__ == '__main__':

    port = "/dev/ttyUSB0"
    baud = 38400
    kernel = None
    ramdisk = None
    boot = None
    reboot = None
    quiet = None
    tftp_ip = None

    if len(sys.argv) < 2:
        usage()
        sys.exit(0)

    # parse command line

    try:
        opts, args = getopt.getopt(sys.argv[1:],
                "p:k:r:bRhq",
                ["port=", "kernel=","ramdisk=","bootos","reboot","help","quiet"]
                )
    except getopt.GetoptError:
        usage()
        sys.exit(2)

    for o, a in opts:
        if o in ("-h","--help"):
            usage()
            sys.exit()
        elif o in ("-k","--kernel"):
            kernel = a
        elif o in ("-r","--ramdisk"):
            ramdisk = a
        elif o in ("-b","--bootos"):
            boot = 1
        elif o in ("-R","--reboot"):
            reboot = 1
        elif o in ("-p","--port"):
            port = o
        elif o in ("-q","--quiet"):
            quiet = 1

    # check for arguments and validate IP address
    # when required by commands
    if len(args)>0 and re.match(ipv4_regex,args[0]):
        tftp_ip = args[0]
    else: 
        if kernel or ramdisk:
            sys.exit("Error: invalid IP address!")

    try:
         s = serial.Serial('/dev/ttyUSB0',38400)
    except:
         sys.stderr.write("Error: Could not open port: %s\n" % (port))
         sys.exit(1)

    # test if armmon is responding on bogus input
    test_armmon()

    # carry out commands     

    if reboot:
        print "Rebooting compulab ..."
        s.write("reboot\n")
        s.write("y\n")
        s.write("y\n")
        s.close()
        sys.exit(0)

    if kernel:
        print "Downloading kernel ..."
        cmd = "download kernel tftp %s %s\n" % (kernel,tftp_ip)
        s.write(cmd)
        data = s.readline()
        data = s.readline()

        print "Flashing kernel ..."
        cmd = "flash kernel\n"
        s.write(cmd)
        wait_flash_complete()


    if ramdisk:
        print "Downloading ramdisk ..."
        cmd = "download ramdisk tftp %s %s\n" % (ramdisk,tftp_ip)
        s.write(cmd)
        s.readline()
        s.readline()

        print "Flashing ramdisk ..."
        cmd = "flash ramdisk\n"
        s.write(cmd)
        wait_flash_complete()

    if boot:
        print "Booting Linux ..."
        s.write("bootos\n")

    s.close()
    sys.exit(0)
