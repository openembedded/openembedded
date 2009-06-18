OBJS = \
	./net/sourceforge/dvb/projectx/audio/AudioFormat.o \
	./net/sourceforge/dvb/projectx/audio/AudioFormatAAC.o \
	./net/sourceforge/dvb/projectx/audio/AudioFormatAC3.o \
	./net/sourceforge/dvb/projectx/audio/AudioFormatDTS.o \
	./net/sourceforge/dvb/projectx/audio/AudioFormatLPCM.o \
	./net/sourceforge/dvb/projectx/audio/AudioFormatMPA.o \
	./net/sourceforge/dvb/projectx/audio/AudioFormatWAV.o \
	./net/sourceforge/dvb/projectx/audio/MpaConverter.o \
	./net/sourceforge/dvb/projectx/audio/MpaDecoder.o \
	./net/sourceforge/dvb/projectx/common/Common.o \
	./net/sourceforge/dvb/projectx/common/GuiInterface.o \
	./net/sourceforge/dvb/projectx/common/GuiInterfaceIF.o \
	./net/sourceforge/dvb/projectx/common/JobCollection.o \
	./net/sourceforge/dvb/projectx/common/JobProcessing.o \
	./net/sourceforge/dvb/projectx/common/Keys.o \
	./net/sourceforge/dvb/projectx/common/Resource.o \
	./net/sourceforge/dvb/projectx/common/Settings.o \
	./net/sourceforge/dvb/projectx/common/Start.o \
	./net/sourceforge/dvb/projectx/io/BitWalker.o \
	./net/sourceforge/dvb/projectx/io/IDDBufferedOutputStream.o \
	./net/sourceforge/dvb/projectx/io/RawFile.o \
	./net/sourceforge/dvb/projectx/io/StandardBuffer.o \
	./net/sourceforge/dvb/projectx/net/WebInterface.o \
	./net/sourceforge/dvb/projectx/net/X_URLDecoder.o \
	./net/sourceforge/dvb/projectx/parser/CommonParsing.o \
	./net/sourceforge/dvb/projectx/parser/Gop.o \
	./net/sourceforge/dvb/projectx/parser/GopArray.o \
	./net/sourceforge/dvb/projectx/parser/HpFix.o \
	./net/sourceforge/dvb/projectx/parser/MainProcess.o \
	./net/sourceforge/dvb/projectx/parser/Scan.o \
	./net/sourceforge/dvb/projectx/parser/StreamBuffer.o \
	./net/sourceforge/dvb/projectx/parser/StreamConverter.o \
	./net/sourceforge/dvb/projectx/parser/StreamDemultiplexer.o \
	./net/sourceforge/dvb/projectx/parser/StreamParser.o \
	./net/sourceforge/dvb/projectx/parser/StreamParserBase.o \
	./net/sourceforge/dvb/projectx/parser/StreamParserESAudio.o \
	./net/sourceforge/dvb/projectx/parser/StreamParserESSubpicture.o \
	./net/sourceforge/dvb/projectx/parser/StreamParserESVideo.o \
	./net/sourceforge/dvb/projectx/parser/StreamParserPESPrimary.o \
	./net/sourceforge/dvb/projectx/parser/StreamParserPESSecondary.o \
	./net/sourceforge/dvb/projectx/parser/StreamParserPVA.o \
	./net/sourceforge/dvb/projectx/parser/StreamParserTS.o \
	./net/sourceforge/dvb/projectx/parser/StreamProcess.o \
	./net/sourceforge/dvb/projectx/parser/StreamProcessAudio.o \
	./net/sourceforge/dvb/projectx/parser/StreamProcessBase.o \
	./net/sourceforge/dvb/projectx/parser/StreamProcessLPCMAudio.o \
	./net/sourceforge/dvb/projectx/parser/StreamProcessSubpicture.o \
	./net/sourceforge/dvb/projectx/parser/StreamProcessTeletext.o \
	./net/sourceforge/dvb/projectx/parser/StripAudio.o \
	./net/sourceforge/dvb/projectx/parser/StripMedion.o \
	./net/sourceforge/dvb/projectx/parser/StripRelook.o \
	./net/sourceforge/dvb/projectx/parser/TS_PMTParser.o \
	./net/sourceforge/dvb/projectx/parser/VBI.o \
	./net/sourceforge/dvb/projectx/subtitle/Bitmap.o \
	./net/sourceforge/dvb/projectx/subtitle/BMP.o \
	./net/sourceforge/dvb/projectx/subtitle/CharSet.o \
	./net/sourceforge/dvb/projectx/subtitle/ColorAreas.o \
	./net/sourceforge/dvb/projectx/subtitle/DVBSubpicture.o \
	./net/sourceforge/dvb/projectx/subtitle/Subpicture.o \
	./net/sourceforge/dvb/projectx/subtitle/Sup2VobSub.o \
	./net/sourceforge/dvb/projectx/subtitle/Teletext.o \
	./net/sourceforge/dvb/projectx/subtitle/UnicodeWriter.o \
	./net/sourceforge/dvb/projectx/thirdparty/Chapters.o \
	./net/sourceforge/dvb/projectx/thirdparty/D2V.o \
	./net/sourceforge/dvb/projectx/thirdparty/Ifo.o \
	./net/sourceforge/dvb/projectx/thirdparty/TS.o \
	./net/sourceforge/dvb/projectx/video/MpvDecoder.o \
	./net/sourceforge/dvb/projectx/video/Preview.o \
	./net/sourceforge/dvb/projectx/video/PreviewObject.o \
	./net/sourceforge/dvb/projectx/video/Video.o \
	./net/sourceforge/dvb/projectx/video/WSS.o \
	./net/sourceforge/dvb/projectx/xinput/DirType.o \
	./net/sourceforge/dvb/projectx/xinput/file/XInputDirectoryImpl.o \
	./net/sourceforge/dvb/projectx/xinput/file/XInputFileImpl.o \
	./net/sourceforge/dvb/projectx/xinput/FileType.o \
	./net/sourceforge/dvb/projectx/xinput/StreamInfo.o \
	./net/sourceforge/dvb/projectx/xinput/topfield_raw/RawFileInputStream.o \
	./net/sourceforge/dvb/projectx/xinput/topfield_raw/RawInterface.o \
	./net/sourceforge/dvb/projectx/xinput/topfield_raw/RawReadIF.o \
	./net/sourceforge/dvb/projectx/xinput/topfield_raw/XInputDirectoryImpl.o \
	./net/sourceforge/dvb/projectx/xinput/topfield_raw/XInputFileImpl.o \
	./net/sourceforge/dvb/projectx/xinput/XInputDirectory.o \
	./net/sourceforge/dvb/projectx/xinput/XInputDirectoryIF.o \
	./net/sourceforge/dvb/projectx/xinput/XInputFile.o \
	./net/sourceforge/dvb/projectx/xinput/XInputFileIF.o \
	./net/sourceforge/dvb/projectx/xinput/XInputStream.o

all: projectx

projectx: $(OBJS)
	$(CROSS_COMPILE)gcj $(JFLAGS) -c -o ac3.o --resource ac3.bin ../resources/ac3.bin
	$(CROSS_COMPILE)gcj $(JFLAGS) -c -o pjxresources_en.o --resource pjxresources_en.properties ../resources/pjxresources_en.properties
	$(CROSS_COMPILE)gcj $(JFLAGS) $(OBJS) pjxresources_en.o ac3.o -o projectx \
		--main=net.sourceforge.dvb.projectx.common.Start \
		-Djava.awt.headless=true $(LDFLAGS) $(GCJ_ARCHIVES)
	$(CROSS_COMPILE)strip --strip-all projectx

projectx-static: $(OBJS)
	$(CROSS_COMPILE)gcj $(JFLAGS) -c -o ac3.o --resource ac3.bin ../resources/ac3.bin
	$(CROSS_COMPILE)gcj $(JFLAGS) -c -o pjxresources_en.o --resource pjxresources_en.properties ../resources/pjxresources_en.properties
	$(CROSS_COMPILE)gcj $(JFLAGS) $(OBJS) pjxresources_en.o ac3.o -Djava.awt.headless=true --main=net.sourceforge.dvb.projectx.common.Start -save-temps
	$(CROSS_COMPILE)gcc -o projectx $(OBJS) pjxresources_en.o ac3.o ./net.sourceforge.dvb.projectx.common.Startmain.i \
	-shared-libgcc -Wl,-non_shared -lgcj -Wl,-call_shared -lsupc++ -Wl,--as-needed -lgcc_s -lpthread -lc -lm -ldl -Wl,--no-as-needed
	$(CROSS_COMPILE)strip --strip-all projectx

clean:
	rm -rf $(OBJS)
	rm *.o *.i *.s
	rm projectx

%.o: %.java
	$(CROSS_COMPILE)gcj $(JFLAGS) -c $< -o $@
