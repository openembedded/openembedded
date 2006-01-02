# to use another configuration, duplicate this file, change the sizes,
# change the filename accordingly, and add the followin line to local.conf:
# PREFERRED_PROVIDER_virtual/kernel_kernel24 = "opensimpad-64+0"

SECTION = "kernel"
include opensimpad_${PV}.bb

# fraction of the memory (in Mb) used for RAM
SIMPAD_MEM = "64"
# fraction of the memory (in Mb) used as a ramdisk
SIMPAD_RD = "0"
