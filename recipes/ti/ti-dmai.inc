DESCRIPTION = "DMAI for TI ARM/DSP processors"

BRANCH = "branches/BRANCH_BRIJESH_DMAI_DEV_2_xx"
BRANCH_omapl138 = "trunk"
BRANCH_omapl137 = "trunk"
BRANCH_6467 = "branches/GITPSP_INT_101009"

SRCREV = "423"

SRC_URI = "svn://gforge.ti.com/svn/dmai/;module=${BRANCH};proto=https;user=anonymous;pswd='' \
		file://loadmodules-ti-dmai-dm355_al.sh \
		file://loadmodules-ti-dmai-dm365_al.sh \
		file://loadmodules-ti-dmai-dm6446_al.sh \
		file://loadmodules-ti-dmai-o3530_al.sh \
		file://loadmodules-ti-dmai-ol138_al.sh \
	"

S = "${WORKDIR}/${BRANCH}/davinci_multimedia_application_interface"

# Yes, the xdc stuff still breaks with a '.' in PWD
PE = "1"
PV = "1.0+svnr${SRCPV}"

INHIBIT_PACKAGE_STRIP = "1"
