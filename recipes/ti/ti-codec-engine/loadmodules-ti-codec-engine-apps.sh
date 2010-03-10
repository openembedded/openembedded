#
# Default Memory Map - for OMAP3530 CE 2.21 examples
#
# Start Addr    Size    Description
# -------------------------------------------
# 0x80000000    80 MB   Linux
# 0x85000000    08 MB   CMEM
# 0x86000000    24 MB   DDRALGHEAP
# 0x87800000     6 MB   DDR2 (BIOS, Codecs, Applications)
# 0x87E00000     1 MB   DSPLINK (MEM)
# 0x87F00000     4 KB   DSPLINK (RESET)
# 0x87F01000  1020 KB   unused

# sanity check to verify that we're using the right mem=xxM (80M in this case)
awk '/MemTotal:/ {
    mem=$2

    if (mem > 80 * 1024)
        print "Warning! You need to use mem=80M or less on the kernel cmdline"

    printf "You have %dkB total memory for Linux\n", mem
}' /proc/meminfo

# Select cmemk parameters for best fit, i.e. starting at 0x85000000
modprobe cmemk phys_start=0x85000000 phys_end=0x86000000 pools=20x4096,8x131072,5x1048576,1x1429440,1x256000,1x3600000,5x829440

# insert DSP/BIOS Link driver
#
modprobe dsplinkk

# make /dev/dsplink
#rm -f /dev/dsplink
#mknod /dev/dsplink c `awk "\\$2==\"dsplink\" {print \\$1}" /proc/devices` 0

# insert Local Power Manager driver
#
modprobe lpm_omap3530
