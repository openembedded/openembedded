DESCRIPTION = "TI DSP Algorithm Interface Standard specification"

PVEXTENSION  ?= ""
BASE_SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/xdais/${PV}/exports"

SRC_URI	= "${BASE_SRC_URI}/xdais_${PV}${PVEXTENSION}.tar.gz"

S = "${WORKDIR}/xdais_${PV}${PVEXTENSION}"


