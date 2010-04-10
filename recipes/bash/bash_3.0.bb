require bash.inc
PR = "r12"

SRC_URI += "\
  file://bash-3.0-fixes.patch;patch=1 \
  file://default_path.patch;patch=1 \
  file://signames-mipsel.diff;patch=1 \
"

SRC_URI[archive.md5sum] = "26c4d642e29b3533d8d754995bc277b3"
SRC_URI[archive.sha256sum] = "72d3f9d80fb4622e79ee5019314668b7bd6747182fa0928c8742002b7568586f"
