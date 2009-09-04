#
# Default Memory Map - for OMAP3530 dsplink examples
#
# Start Addr    Size    Description
# -------------------------------------------
# 0x80000000   126 MB   Linux
# 0x87E00000     2 MB   DSPLINK (MEM) + DDR + DSPLINK (RESET)

# sanity check to verify that we're using the right mem=xxM (126M in this case)
awk '/MemTotal:/ {
    mem=$2

    if (mem > 126 * 1024)
        print "Warning! You need to use mem=126M or less on the kernel cmdline"

    printf "You have %dkB total memory for Linux\n", mem
}' /proc/meminfo

# insert DSP/BIOS Link driver
#
modprobe dsplinkk

# make /dev/dsplink
#rm -f /dev/dsplink
#mknod /dev/dsplink c `awk "\\$2==\"dsplink\" {print \\$1}" /proc/devices` 0
