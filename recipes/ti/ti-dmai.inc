DESCRIPTION = "DMAI for TI ARM/DSP processors"

BRANCH = "BRANCH_BRIJESH_DMAI_DEV_2_xx"
BRANCH_6467 = "GITPSP_INT_101009"

SRCREV = "364"

SRC_URI = "svn://gforge.ti.com/svn/dmai/branches;module=${BRANCH};proto=https;user=anonymous;pswd='' \
		file://loadmodules-ti-dmai-dm355_al.sh \
		file://loadmodules-ti-dmai-dm365_al.sh \
		file://loadmodules-ti-dmai-dm6446_al.sh \
		file://loadmodules-ti-dmai-o3530_al.sh \
	"

S = "${WORKDIR}/${BRANCH}/davinci_multimedia_application_interface"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "svnr${SRCREV}"

INHIBIT_PACKAGE_STRIP = "1"
