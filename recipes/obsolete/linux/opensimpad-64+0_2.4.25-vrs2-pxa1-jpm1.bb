SECTION = "kernel"
require opensimpad_${PV}.bb

SIMPAD_MEM = "64"
SIMPAD_RD = "0"

SRC_URI[kernel.md5sum] = "5fc8e9f43fa44ac29ddf9a9980af57d8"
SRC_URI[kernel.sha256sum] = "877af8ed89e56af004bb0662c1a9cfc785b40c602f71a8bf81521991026cf2f0"
SRC_URI[patch.md5sum] = "5c54040bba6fea2bfb47df01056e953f"
SRC_URI[patch.sha256sum] = "d35213dc854f1e1a08512154c7a92fb94d9f0506cc5107f8b2f248412679fb53"
