DESCRIPTION = "DMAI for TI ARM/DSP processors"

# NOTE: Use Brijesh' DMAI development branch. The URL *must* be updated once
# we have stable DMAI 2.x on gforge.
SRCREV = "265"
SRC_URI = "svn://gforge.ti.com/svn/dmai/branches;module=BRANCH_BRIJESH_DMAI_DEV_2_xx;proto=https;user=anonymous;pswd='' \
		file://loadmodules-ti-dmai-dm355_al.sh \
		file://loadmodules-ti-dmai-dm6446_al.sh \
		file://loadmodules-ti-dmai-o3530_al.sh \
        file://touchbook-support.patch;patch=1 \
	"

S = "${WORKDIR}/BRANCH_BRIJESH_DMAI_DEV_2_xx/davinci_multimedia_application_interface"
# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "svnr${SRCREV}"

