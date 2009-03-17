require jamvm.inc

SRC_URI += "file://debian-jni.patch;patch=1;pnum=0"

PR = "r3"

do_configure_prepend() {
  # Replaces the placeholder OE_LIBDIR_JNI with the JNI library directory
  # configured in OE.
  sed -i -e "s|OE_LIBDIR_JNI|${libdir_jni}|" src/dll.c
}

