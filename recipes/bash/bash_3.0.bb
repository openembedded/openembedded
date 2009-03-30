require bash.inc
PR = "r11"

SRC_URI += "\
  file://bash-3.0-fixes.patch;patch=1 \
  file://default_path.patch;patch=1 \
  file://signames-mipsel.diff;patch=1 \
"
