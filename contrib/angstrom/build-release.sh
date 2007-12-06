#!/bin/bash

DO_UCLIBC=0

do_build() {
	echo "MACHINE = \"$BUILD_MACHINE\"" > conf/auto.conf

	BUILD_MODE="glibc"
	if [ "$BUILD_CLEAN" != "" ]
	then
		bitbake -c clean $BUILD_CLEAN
	fi

	for target in $BUILD_TARGETS
	do
		bitbake $target && do_report_success
	done

	if [ $DO_UCLIBC = 1 ]
	then
		BUILD_MODE="uclibc"
		echo 'ANGSTROM_MODE = "uclibc"' >> conf/auto.conf
		for target in $BUILD_TARGETS
		do
			bitbake $target && do_report_success
		done
	fi
}

do_report_success() {

	echo "$(date -u +%Y%M%d%H%M) $target ($BUILD_MODE) built for $machine" >> autobuilder.log
}

# No graphics
for machine in ep93xx gumstix-connex efika omap5912osk
do
	BUILD_MACHINE=$machine
	BUILD_TARGETS="minimal-image console-image"
	do_build
done

for machine in ixp4xxle ixp4xxbe 
do
	BUILD_MACHINE=$machine
	BUILD_TARGETS="nslu2-minimal-image"
	do_build
done	 

# build altboot images for zaurus
for machine in c7x0 poodle tosa akita spitz collie
do
	BUILD_MACHINE=$machine
	BUILD_TARGETS="altboot-console-image"
	do_build
done  

# graphics, flash storage
for machine in fic-gta01 a780 at91sam9263ek qemuarm h2200 h4000 poodle tosa hx4700 c7x0 spitz akita collie 
do
	BUILD_MACHINE=$machine
	BUILD_TARGETS="minimal-image console-image x11-image"
	do_build
done

# graphics, disk storage	
for machine in spitz 
do
	BUILD_MACHINE=$machine
	BUILD_TARGETS="x11-gpe-image x11-pimlico-image x11-office-image"
	BUILD_CLEAN="qmake2-native"
	do_build
done 

#phones
for machine in fic-gta01 a780 
do
	BUILD_MACHINE=$machine
	BUILD_TARGETS="openmoko-image"
	BUILD_CLEAN="qmake2-native"
	do_build
done	 
