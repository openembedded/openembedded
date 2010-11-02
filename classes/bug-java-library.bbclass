# We do not want to have symlinks for jar files

inherit java-library

# File name of the libraries' main Jar file (no version in name)
JARFILENAME = "${BPN}.jar"

# We do not want symlinks for jar files
ALTJARFILENAMES = ""

java_install() {
  oe_jarinstall ${JARFILENAME}
}

java_stage() {
  oe_jarinstall -s ${JARFILENAME}
}
