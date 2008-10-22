# Inherit this bbclass for each java recipe that builds a Java library (jar file[s]).
#
# It automatically adds important build dependencies, defines JPN (Java Package Name)
# a package named ${JPN} whose contents are those of ${datadir}/java (the jar location).
#
# The JPN is basically lib${PN}-java but takes care of the fact that ${PN} already
# starts with "lib" and/or ends with "-java". In case the "lib" prefix is part of
# your package's normal name (e.g. liberator) the guessing is wrong and you have
# to set JPN manually!

inherit java

# use java_stage for native packages
JAVA_NATIVE_STAGE_INSTALL = "1"

def java_package_name(d):
  import bb;

  pre=""
  post=""

  pn = bb.data.getVar('PN', d, 1)
  if not pn.startswith("lib"):
    pre='lib'

  if not pn.endswith("-java"):
    post='-java'

  return pre + pn + post

JPN ?= "${@java_package_name(d)}"

DEPENDS_prepend = "virtual/javac-native fastjar-native "

PACKAGES = "${JPN}"

PACKAGE_ARCH_${JPN} = "all"

FILES_${JPN} = "${datadir_java}"

# File name of the libraries' main Jar file
JARFILENAME = "${BP}.jar"

# Space-separated list of alternative file names.
ALTJARFILENAMES = "${BPN}.jar"

# Java "source" distributions often contain precompiled things
# we want to delete first.
do_removebinaries() {
  find ${WORKDIR} -name "*.jar" -exec rm {} \;
  find ${WORKDIR} -name "*.class" -exec rm {} \;
}

addtask removebinaries after do_unpack before do_patch

java_install() {
  oe_jarinstall ${JARFILENAME} ${ALTJARFILENAMES}
}

do_install() {
  java_install
}

java_stage() {
  oe_jarinstall -s ${JARFILENAME} ${ALTJARFILENAMES}
}

do_stage() {
  java_stage
}
