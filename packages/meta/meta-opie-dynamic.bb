BROKEN = 1
#
# FIXME:
# we need to get the necessary support from the OE infrastructure
# to allow the dynamic package to work
#
DESCRIPTION = "Meta-package for Opie"

def opie_packages(d):
	import bb, os
	files = os.listdir( bb.data.getVar( "TOPDIR", d, True ) )
	pkgs = [ f for f in files if f.startswith( "opie-" ) and f != "opie-3rdparty" ]
        return " ".join( pkgs )

OPIE_PACKAGES := "${@opie_packages(d)}"

DEPENDS = "qte libqpe-opie libopie2 manufacturers ${OPIE_PACKAGES}"

LICENSE = MIT
