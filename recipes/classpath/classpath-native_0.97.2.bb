require classpath-native.inc

PR = "r7"

# The code affected by the javanet-local patch
# is usually not compiled. However if someone changes
# to --enable-local-sockets it will.
SRC_URI += "\
  file://netif_16.patch;patch=1;pnum=0 \
  file://SimpleName.diff;patch=1;pnum=0 \
  file://javanet-local.patch;patch=1;pnum=0 \
  file://sun-security-getproperty_0.96.1.patch;patch=1;pnum=0 \
  file://ecj_java_dir.patch;patch=1 \
  file://autotools.patch;patch=1 \
  file://decimalformat.patch;patch=1 \
  file://cp-byte-loophelper.patch;patch=1;pnum=0 \
  file://miscompilation.patch;patch=1 \
  file://toolwrapper-exithook.patch;patch=1 \
  "

do_unpackpost() {
  # Kind of patch: Moves package "org.w3c.dom.html2" to "org.w3c.dom.html"
	mv external/w3c_dom/org/w3c/dom/html2 \
			external/w3c_dom/org/w3c/dom/html

	find examples/gnu/classpath/examples/html gnu/xml/dom/html2 external/w3c_dom/org/w3c/dom/html -name "*.java" \
		-exec sed -i -e"s|org.w3c.dom.html2|org.w3c.dom.html|" {} \;

	sed -i -e"s|org/w3c/dom/html2|org/w3c/dom/html|" external/w3c_dom/Makefile.am
}

addtask unpackpost after do_unpack before do_patch

