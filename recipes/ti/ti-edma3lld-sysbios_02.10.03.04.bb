require ti-edma3lld-sysbios.inc
require ti-eula-unpack.inc

PV = "02_10_03_04"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_tii/psp/edma3_lld/edma3-lld-bios6/${PV}/exports/EDMA3_LLD_setuplinux_${PV}.bin;name=edma3lldsysbiosbin"

SRC_URI[edma3lldsysbiosbin.md5sum] = "9c1d9b8ee600f234ad635d3866b9f850"
SRC_URI[edma3lldsysbiosbin.sha256sum] = "7becc0bf7f2c8126f4bc1fcde8daf50db22a55f7d13abc733db96380f10e910f"

BINFILE="EDMA3_LLD_setuplinux_${PV}.bin"
TI_BIN_UNPK_CMDS="Y:workdir"
