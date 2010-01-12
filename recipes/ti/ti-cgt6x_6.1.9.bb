require ti-cgt6x.inc

# download ti_cgt_c6000_6.1.9_setup_linux_x86.bin from https://www-a.ti.com/downloads/sds_support/TICodegenerationTools/download.htm and copy in Arago/OE download directory.

SRC_URI = "http://install.source.dir.local/ti_cgt_c6000_6.1.9_setup_linux_x86.bin"

BINFILE = "ti_cgt_c6000_6.1.9_setup_linux_x86.bin"

S = "${WORKDIR}/cgt"

# Yes, the xdc stuff still breaks with a '.' in PWD

PE = "1"
PV = "6_1_9"
PR = "r1"



