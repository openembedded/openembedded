require busybox.inc
require busybox_1.1x.inc
PR = "${INC_PR}.4"

SRC_URI += "\
  file://0000-wget-no-check-certificate.patch \
"

SRC_URI[md5sum] = "6059ac9456de6fb18dc8ee4cd0ec9240"
SRC_URI[sha256sum] = "d74020ad2cc5a4dcc5109c44dbd0e22582d6ce42954b0f1ff29763c8c0ff03cb"

# gcc 4.5 has this bug on thumb
# http://gcc.gnu.org/bugzilla/show_bug.cgi?id=44557
# so add -fomit-frame-pointer
# this will be removed once the above bug is fixed.

CFLAGS_append = " -fomit-frame-pointer"
