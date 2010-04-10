require gst-plugins.inc

PR = "${INC_PR}.1"

DEPENDS += "gst-plugins-base mpeg2dec libsidplay"

SRC_URI += "\
  file://gstmad_16bit.patch;patch=1 \
  file://gstsid_autofoo_HACK.patch;patch=1 \
"

python() {
	# Don't build, if we are building an ENTERPRISE distro
	enterprise = bb.data.getVar("ENTERPRISE_DISTRO", d, 1)
	if enterprise == "1":
		raise bb.parse.SkipPackage("gst-plugins-ugly will only build if ENTERPRISE_DISTRO != 1")
}


SRC_URI[archive.md5sum] = "dfe2e201e066a3e86a9598b6769d9739"
SRC_URI[archive.sha256sum] = "681d3cf7ae124bff1949187db858e5439a41be162bdad59dd69b52b70fd62dfa"
