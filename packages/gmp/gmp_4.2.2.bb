PR = "r1"

SRC_URI_append += "file://02_noexec-stack.diff;patch=1 \
		   file://03_gnu89-inline.diff;patch=1 \
		   file://mpf_set_str_c.diff;patch=1 \
		   file://sh4-asmfix.patch;patch=1 \
		  "
require gmp.inc
