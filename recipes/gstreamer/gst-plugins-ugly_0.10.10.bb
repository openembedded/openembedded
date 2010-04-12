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


SRC_URI[archive.md5sum] = "031205d5599fce73fc36766f928b2515"
SRC_URI[archive.sha256sum] = "ced80afedd105cb9b1b72749f8bda29c71fa9eda06120d6b07e7362f705c9987"
