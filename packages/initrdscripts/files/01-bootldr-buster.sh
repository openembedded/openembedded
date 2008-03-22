#!/bin/sh

cmdl=`cat /proc/cmdline`
#cmdl="console=ttySA0,115200 console=ttySB0,115200"
if expr "$cmdl" : '.*mtdparts=ipaq' > /dev/null; then
    echo "!!!!!!!!"
    echo "Detected Compaq bootldr or derivative"
    echo "Kernel command line is assumed to be bogus and ignored"
    echo "!!!!!!!!"
    CMDLINE="console=ttyS0,115200 console=tty0"
    sleep 3
fi

# The main trouble is the bogus console=ttySA0 passed by bootldr
# It appears that kernel doesn't have protection against only invalid
# consoles being passed on the command line, which means that the
# kernel is deaf and dumb when booted by bootldr

INVALID_CONSOLE=0
VALID_CONSOLE=0

for arg in $cmdl; do
        optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
        case $arg in
            console=*)
		if expr "$optarg" : 'ttySA[0-9]\+' > /dev/null; then
		    INVALID_CONSOLE=1
                elif expr "$optarg" : 'ttyS\?[0-9]\+' > /dev/null; then
		    VALID_CONSOLE=1
		fi
		;;
        esac
done

if [ $INVALID_CONSOLE -eq 1 -a $VALID_CONSOLE -eq 0 ]; then
    echo "!!!!!!!!"
    echo "No valid system console is detected"
    echo "Explicitly using /dev/tty0 for input/output"
    echo "!!!!!!!!"
    CONSOLE="/dev/tty0"
fi
