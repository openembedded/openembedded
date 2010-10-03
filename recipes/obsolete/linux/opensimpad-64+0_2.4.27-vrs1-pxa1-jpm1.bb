# to use another configuration, duplicate this file, change the sizes,
# change the filename accordingly, and add the followin line to local.conf:
# PREFERRED_PROVIDER_virtual/kernel_kernel24 = "opensimpad-64+0"

SECTION = "kernel"
require opensimpad_${PV}.bb

# fraction of the memory (in Mb) used for RAM
SIMPAD_MEM = "64"
# fraction of the memory (in Mb) used as a ramdisk
SIMPAD_RD = "0"

SRC_URI[patch.md5sum] = "5c54040bba6fea2bfb47df01056e953f"
SRC_URI[patch.sha256sum] = "d35213dc854f1e1a08512154c7a92fb94d9f0506cc5107f8b2f248412679fb53"
