DESCRIPTION = "The Openmoko Today2 vfolder files"
SECTION = "openmoko/misc"
PV = "0.1.0+svnr${SRCREV}"
FILE_PR = "r3"
RCONFLICTS_${PN} = "matchbox-common"

inherit openmoko2

FILES_${PN} += "${datadir}"
