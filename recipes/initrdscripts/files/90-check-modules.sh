#!/bin/sh
# Check that modules for the current kernel exist, error out otherwise

uname=`cat /proc/version`
ver=`expr "x$uname" : 'xLinux version \([^ ]\+\) '`

if [ -n "$BOOT_ROOT" -a ! -d "$BOOT_ROOT/lib/modules/$ver" ]; then
    echo -e "\033[1m===================="
    echo "ERROR!"
    echo "There are no modules for this kernel"
    echo "version ($ver) in the root file "
    echo "system, which will lead to boot failure or"
    echo "broken functionally. If you performed"
    echo "a kernel upgrade, make sure that version"
    echo "installed in root filesystem matches"
    echo "version used in bootloader."
    echo -e "====================\033[0m"
    echo

    echo "System halted"
    while true; do
	sleep 10000
    done
fi
