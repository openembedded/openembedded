LICENSE = "AL2.0"
AUTHOR = "Apache Software Foundation"

inherit java-library

DEPENDS = "fastjar-native"

S = "${WORKDIR}/${BP}-src"

# Directory in which the projects sources are located.
MAINSOURCES = "src/java"

# Directories which should appear in the -sourcepath argument.
COMPILE_SOURCEPATH = "src/java"

COMPILE_FINDARGS = "-name '*.java'"
FINDARGS = "-name '*.properties'"

# Directories to be removed after compilation.
CLEAN_PATH = ""

# Some projects have a replaceable version number in their manifest template.
do_unpackpost() {
  if [ -d src/conf ]
  then
    find src/conf -exec \
      sed -i -e "s|@version@|${PV}|" {} \;
  fi
}

addtask unpackpost after do_unpack before do_patch
# Compile step is very similar for Jakarta commons packages
do_compile() {
  mkdir -p build

  if [ "${CP}" ]
  then
		oe_makeclasspath cp -s ${CP}
  else
    cp=.
  fi

  echo "javac -sourcepath ${COMPILE_SOURCEPATH} -cp $cp -d build \`find ${MAINSOURCES} ${COMPILE_FINDARGS}\`"
  javac -sourcepath ${COMPILE_SOURCEPATH} -cp $cp -d build `find ${MAINSOURCES} ${COMPILE_FINDARGS}`

  # Copy extraneous files
  echo "(cd ${MAINSOURCES} && find . ${FINDARGS} -exec cp {} ../../build/{} \;)"
  (cd ${MAINSOURCES} && find . ${FINDARGS} -exec cp {} ../../build/{} \;)

	# Optionally remove stuff after compilation (needed for sourcepath hacks).
	if [ ${CLEAN_PATH} ]; then
		rm -rf ${CLEAN_PATH}
	fi

  # Some projects have manifest, some have not. This works for both.
  if [ -f src/conf/MANIFEST.MF ]
  then
    fastjar -C build -c -m src/conf/MANIFEST.MF -f ${JARFILENAME} .
  else
    fastjar -C build -c -f ${JARFILENAME} .
  fi
}
