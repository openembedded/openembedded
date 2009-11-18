DESCRIPTION = "Low level 2D blitting/blending graphics acceleration services support on DM6446, OMAP3530 and OMAP-L137."

require ti-paths.inc

inherit autotools

DEPENDS = "ti-codec-engine ti-dmai"

# Fetch source from svn repo
SRCREV = "2"
SRC_URI = "svn://gforge.ti.com/svn/${PN};module=trunk;proto=https;user=anonymous;pswd='' \
           file://recent-linux.diff;patch=1 \
"

# Again, no '.' in PWD allowed :(
PV = "0+svnr${SRCPV}"
PR = "r1"

S = "${WORKDIR}/trunk/bitblit"

XDC_TARGET  				= gnu.targets.arm.GCArmv5T
XDC_PLATFORM_dm6446-evm 	= ti.platforms.evmDM6446
XDC_PLATFORM_da830-omapl137-evm 	= ti.platforms.omapl137
PLATFORM_XDC				= ${XDC_PLATFORM}

export XDC_TARGET
export XDC_PLATFORM
export PLATFORM_XDC 

PLATFORM_dm6446-evm 		= "dm6446"
PLATFORM_da830-omapl137-evm = "ol137"

export LINUXLIBS_INSTALL_DIR="${STAGING_DIR_HOST}/usr"
export EXEC_DIR = "${D}${datadir}/ti/bitblit/"

CPPFLAGS_append 			= " -DPlatform_${PLATFORM}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile() {
	oe_runmake -e all
}

do_install() {
	oe_runmake -e install
}
