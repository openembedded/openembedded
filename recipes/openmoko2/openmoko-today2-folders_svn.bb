DESCRIPTION = "The Openmoko Today2 vfolder files"
SECTION = "openmoko/misc"
PV = "0.1.0+svnr${SRCPV}"
PR = "r3"
RCONFLICTS_${PN} = "matchbox-common"

inherit openmoko2

FILES_${PN} += "${datadir}"
