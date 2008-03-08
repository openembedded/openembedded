#!/bin/sh

cmdl=`cat /proc/cmdline`
if expr "$cmdl" : '.*mtdparts=ipaq' > /dev/null; then
    echo "!!!!!!!!"
    echo "Detected Compaq bootldr or derivative"
    echo "Kernel command line is assumed to be bogus and ignored"
    echo "!!!!!!!!"
    CMDLINE=" "
    sleep 3
fi
