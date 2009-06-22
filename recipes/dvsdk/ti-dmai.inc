DESCRIPTION = "DMAI for TI ARM/DSP processors"

# NOTE: Use Brijesh' DMAI development branch. The URL *must* be updated once
# we have stable DMAI 2.x on gforge.
SRCREV = "195"
SRC_URI = "svn://gforge.ti.com/svn/dmai/branches;module=BRIJESH_GIT_031809;proto=https;user=anonymous;pswd='' \
		file://loadmodules-ti-dmai-dm355_al.sh \
		file://loadmodules-ti-dmai-dm6446_al.sh \
		file://loadmodules-ti-dmai-o3530_al.sh \
	"

S = "${WORKDIR}/BRIJESH_GIT_031809/davinci_multimedia_application_interface"
# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "svnr${SRCREV}"
PR = "r27"

