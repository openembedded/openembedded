#!/bin/sh

killproc()
{
   pid=`/bin/ps -e x |
        /bin/grep $1 |
        /bin/grep -v grep |
        /bin/sed -e 's/^  *//' -e 's/ .*//'`
   [ "$pid" != "" ] && kill $pid
}

usage()
{
    echo "Usage: $0 {start|stop}"
}

if [ $# -lt 1 ] ; then usage ; exit ; fi

case "$1" in
start)
    echo -n "Start pbserver"
    # make sure lo interface is configured (otherwise qpobox will not bind to pbserver)
    ifconfig lo|grep 127.0.0.1 >/dev/null || ifconfig lo 127.0.0.1
    cd @palmtopdir@/pobox; ./pbserver > /dev/null &
    echo
    sleep 1
    ;;

stop)
    echo -n "Stop pbserver"
    killproc pbserver
    echo
    ;;

esac

exit 0

