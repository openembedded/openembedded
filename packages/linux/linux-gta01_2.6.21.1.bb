require linux-gta01.inc

MOKOR = "moko9"
PR = "${MOKOR}-r0"
VANILLA_VERSION = "2.6.21.1"

SRC_URI += "svn://svn.openmoko.org/trunk/src/target/kernel;module=patches;proto=http"

