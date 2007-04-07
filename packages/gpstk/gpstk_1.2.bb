DESCRIPTION = "Libraries and applications to facilitate working with GPS data for research and high accuracy uses."
HOMEPAGE = "http://www.gpstk.org/"
LICENSE = "LGPL"
SECTION = "libs"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/gpstk/gpstk-${PV}-src.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools lib_package

EXTRA_OECONF = "--enable-shared"

do_stage() {
    autotools_stage_all
}


# This is a handcrafted do_install because 'make install' isn't working.
# This should install the same files as my native (x86) jam based build, but doesn't since the Makefiles 
# aren't up to date (e.g. bc2sp3 is missing). 
# Koen - 20070325
do_install() {

install -d ${D}${bindir}
install -d ${D}${libdir}
install -d ${D}${includedir}/

for i in bc2sp3 calgps DDBase ddmerge DiscFix EditRinex ephdiff example1 example2 example3 example4 example5 \
         fic2rin ficacheck ficafic ficcheck ficdiff ficfica findMoreThan12 IonoBias mergeFIC mergeRinMet \
         mergeRinNav mergeRinObs mergeSRI mkord mpsolve navdmp NavMerge novaRinex ordClock ordEdit ordGen \
         ordLinEs ordPlot ordStats poscvt posInterp PRSolve ResCor resplot reszilla RinexDump rinexpvt \
         rinexthin RinSum rmwcheck rmwdiff rnwcheck rnwdiff rowcheck rowdiff rstats rtAshtech sp3version \
         TECMaps timeconvert tnl tsrif tsrifsu tsriftu vecsol wheresat 
        do install -m 755 `find . -name $i` ${D}${bindir}/ || true 
done
	cp -pPr src/.libs/libgps* ${D}${libdir}/ 

for i in AlmanacStore.hpp AlmOrbit.hpp ANSITime.hpp Bancroft.hpp BasicFramework.hpp BCEphemerisStore.hpp \
         BinexData.hpp BinexFilterOperators.hpp BinexStream.hpp BinUtils.hpp BivarStats.hpp CheckPRData.hpp \
	 CivilTime.hpp ClockModel.hpp CodeBuffer.hpp CommandOption.hpp CommandOptionParser.hpp \
	 CommandOptionWithCommonTimeArg.hpp CommandOptionWithPositionArg.hpp CommandOptionWithTimeArg.hpp \
	 CommonTime.hpp convhelp.hpp DayTime.hpp DOP.hpp ECEF.hpp EngAlmanac.hpp EngEphemeris.hpp EngNav.hpp \
	 EphemerisRange.hpp EphemerisStore.hpp EpochClockModel.hpp Exception.hpp Expression.hpp ExtractC1.hpp \
	 ExtractCombinationData.hpp ExtractD1.hpp ExtractD2.hpp ExtractData.hpp ExtractL1.hpp ExtractL2.hpp \
	 ExtractLC.hpp ExtractP1.hpp ExtractP2.hpp ExtractPC.hpp FFBinaryStream.hpp FFData.hpp FFStreamError.hpp \
	 FFStream.hpp FFTextStream.hpp FICAStream.hpp FICBase.hpp FICData109.hpp FICData162.hpp FICData62.hpp \
	 FICData9.hpp FICData.hpp FICFilterOperators.hpp FICHeader.hpp FICStreamBase.hpp FICStream.hpp \
	 FileFilterFrame.hpp FileFilterFrameWithHeader.hpp FileFilter.hpp FileHunter.hpp FileSpec.hpp \
	 FileStore.hpp FileUtils.hpp GenXSequence.hpp Geodetic.hpp GeoidModel.hpp geometry.hpp getopt.h \
	 gps_constants.hpp GPSEpochWeekSecond.hpp GPSGeoid.hpp gpstkplatform.h GPSWeekSecond.hpp GPSWeekZcount.hpp \
	 GPSZcount29.hpp GPSZcount32.hpp GPSZcount.hpp icd_200_constants.hpp IonoModel.hpp IonoModelStore.hpp \
	 JulianDate.hpp LinearClockModel.hpp LoopedFramework.hpp MathBase.hpp MatrixBase.hpp \
	 MatrixBaseOperators.hpp MatrixFunctors.hpp Matrix.hpp MatrixImplementation.hpp MatrixOperators.hpp \
	 mergePCodeWords.h MiscMath.hpp MJD.hpp ModeledPR.hpp ModeledPseudorangeBase.hpp ModeledReferencePR.hpp \
	 MOPSWeight.hpp MSCData.hpp MSCStream.hpp ObsClockModel.hpp ObsEpochMap.hpp ObsID.hpp ObsRngDev.hpp \
	 ORDEpoch.hpp PCodeConst.hpp PolyFit.hpp Position.hpp PRSolution.hpp RACRotation.hpp \
	 RinexEphemerisStore.hpp RinexMetBase.hpp RinexMetData.hpp RinexMetFilterOperators.hpp \
	 RinexMetHeader.hpp RinexMetStream.hpp RinexNavBase.hpp RinexNavData.hpp RinexNavFilterOperators.hpp \
	 RinexNavHeader.hpp RinexNavStream.hpp RinexObsBase.hpp RinexObsData.hpp RinexObsFilterOperators.hpp \
	 RinexObsHeader.hpp RinexObsID.hpp RinexObsStream.hpp RinexSatID.hpp RinexUtilities.hpp RTFileFrame.hpp \
	 RungeKutta4.hpp SatID.hpp SimpleIURAWeight.hpp SMODFData.hpp SMODFStream.hpp SolverBase.hpp SolverLMS.hpp \
	 SolverWMS.hpp SP3Base.hpp SP3Data.hpp SP3EphemerisStore.hpp SP3Header.hpp SP3SatID.hpp SP3Stream.hpp \
	 Stats.hpp stl_helpers.hpp StringUtils.hpp SVExclusionList.hpp SVPCodeGen.hpp SystemTime.hpp \
	 TabularEphemerisStore.hpp TimeConstants.hpp TimeConverters.hpp TimeString.hpp TimeTag.hpp Triple.hpp \
	 TropModel.hpp UnixTime.hpp ValidType.hpp VectorBase.hpp VectorBaseOperators.hpp \
	 Vector.hpp VectorOperators.hpp WeightBase.hpp WGS84Geoid.hpp WxObsMap.hpp X1Sequence.hpp \
	 X2Sequence.hpp Xvt.hpp YDSTime.hpp
        do install -m 644 `find . -name $i` ${D}${includedir}/ || true
done
}
