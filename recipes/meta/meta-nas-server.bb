DESCRIPTION = "Meta-package for a network attached storage server"
LICENSE = "MIT"
PR = "r1"

RDEPENDS_${PN} = "\
	task-nas-server-everything \
	"

inherit meta

