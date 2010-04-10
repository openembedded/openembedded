require jamvm.inc

SRC_URI += "file://debian-jni.patch;patch=1;pnum=0"

PR = "r4"

do_configure_prepend() {
  # Replaces the placeholder OE_LIBDIR_JNI with the JNI library directory
  # configured in OE.
  sed -i -e "s|OE_LIBDIR_JNI|${libdir_jni}|" src/dll.c
}


SRC_URI[md5sum] = "a965452442cdbfc94caba57d0dd25a8f"
SRC_URI[sha256sum] = "18b269b1bfad7230384681e89189c6af18584e19cddbf92208c0acef814046ab"
