require flac.inc

PR = "r1"

# fixes from openSUSE:
SRC_URI += "file://flac-gcc43-fixes.diff;patch=1;pnum=0 \
            file://flac-printf-format-fix.diff;patch=1;pnum=0"
