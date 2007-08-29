require linux-gta01.inc

SRC_URI += "svn://svn.openmoko.org/trunk/src/target/kernel;module=patches;proto=http"
SRC_URI += "file://fix-EVIOCGRAB-semantics-2.6.22.5.patch;patch=1"

MOKOR = "moko11"
PR = "${MOKOR}-r2"

VANILLA_VERSION = "2.6.22.5"

