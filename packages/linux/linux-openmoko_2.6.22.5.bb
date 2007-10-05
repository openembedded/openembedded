DESCRIPTION = "Linux 2.6.x (stable) kernel for FIC SmartPhones shipping w/ OpenMoko"

require linux-openmoko.inc

SRC_URI += "svn://svn.openmoko.org/trunk/src/target/kernel;module=patches;proto=http"
SRC_URI += "file://fix-EVIOCGRAB-semantics-2.6.22.5.patch;patch=1"

VANILLA_VERSION = "2.6.22.5"
MOKOR = "moko11+svnr${SRCREV}"
PV = "${VANILLA_VERSION}-${MOKOR}"
PR = "r3"
