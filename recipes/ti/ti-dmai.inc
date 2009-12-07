DESCRIPTION = "DMAI for TI ARM/DSP processors"

BRANCH = "BRANCH_BRIJESH_DMAI_DEV_2_xx"
BRANCH_6467 = "GITPSP_INT_101009"
BRANCH_omapl137 = "BRANCH_KATIE_111309_OMAPL137"

SRCREV = "364"
SRCREV_omapl137 = "382"

SRC_URI = "svn://gforge.ti.com/svn/dmai/branches;module=${BRANCH};proto=https;user=anonymous;pswd='' \
		file://loadmodules-ti-dmai-dm355_al.sh \
		file://loadmodules-ti-dmai-dm365_al.sh \
		file://loadmodules-ti-dmai-dm6446_al.sh \
		file://loadmodules-ti-dmai-o3530_al.sh \
	"

S = "${WORKDIR}/${BRANCH}/davinci_multimedia_application_interface"

# Yes, the xdc stuff still breaks with a '.' in PWD
PE = "1"
PV = "1.0+svnr${SRCPV}"

INHIBIT_PACKAGE_STRIP = "1"
