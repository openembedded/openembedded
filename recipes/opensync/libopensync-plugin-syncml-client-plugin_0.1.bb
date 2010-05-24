PR = "r1"

SRC_URI = "svn://svn.opensync.org/plugins/syncml-client/plugin/tags;module=release-${PV};proto=http \
	file://missing-syncml-config.patch \
	file://syncml-client-plugin-cpp.patch"


S = "${WORKDIR}/release-${PV}"

require libopensync-plugin.inc

DEPENDS += "syncml-client"

