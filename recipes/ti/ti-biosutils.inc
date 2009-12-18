DESCRIPTION = "TI DSP Algorithm Interface Standard specification"

# Have a look at http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/xdais/index.html

BASE_SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/Bios_Utils"

SRC_URI = "${BASE_SRC_URI}/${PV}${PVsuffix}/exports/biosutils_${PV}.tar.gz;name=biosutilstarball"

S = "${WORKDIR}/biosutils_${PV}"


