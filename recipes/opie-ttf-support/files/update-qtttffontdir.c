/*
 * Utility to generate 'fontdir' for Qt/Embedded
 *
 * (C) 2004-2005 Marcin Juszkiewicz <openembedded@hrw.one.pl>
 *
 * License: GPLv2
 *
 * History:
 * 
 * v0.1 2004.10.06 - first version (sent to OPIE devel ML)
 * v0.2 2005.03.12 - added Oblique fonts support
 * v1.0 2005.06.29 - switched font style handling to not based on filenames
 * v1.1 2005.06.29 - fixed filename comparing
 * 
 */ 


#include <ft2build.h>
#include FT_FREETYPE_H 

#include <stdio.h>
#include <dirent.h>
#include <unistd.h>


int main(int argc, char* argv[])
{
	DIR *katalog;
	struct dirent *plik;

	FT_Library  library;
	FT_Face face;
	
	if(argc == 1)
	{
		fprintf(stderr, "Usage: %s <path to TTF fonts>\n", argv[0]);
		exit(10);
	}
	
	if(FT_Init_FreeType(&library))
	{
		fprintf(stderr, "Error during initialising FreeType library.\n");
		exit(5);
	}

	chdir(argv[1]);
	if((katalog = opendir(".")))
	{
		int found_fixed = 0;

		while((plik = readdir(katalog)))
		{
			if(!strstr(plik->d_name, ".ttf"))
			{
				continue;
			}

			if(!FT_New_Face(library, plik->d_name, 0, &face))
			{
				/*
				 *	change spaces in family_name into _
				 */
				
				char* ptr;

				for(ptr = strchr(face->family_name,' '); (ptr = strchr(ptr, ' ')); ) *ptr = '_';

				if(
						face->face_flags & FT_FACE_FLAG_FIXED_WIDTH &&
						!found_fixed &&
						!(face->style_flags & FT_STYLE_FLAG_ITALIC) &&
						!(face->style_flags & FT_STYLE_FLAG_BOLD)
					)
				{
					found_fixed = 1;
					printf("fixed %s/%s FT", argv[1], plik->d_name);

					if(face->style_flags & FT_STYLE_FLAG_ITALIC)
					{
						printf(" y");
					}
					else
					{
						printf(" n");
					}

					if(face->style_flags & FT_STYLE_FLAG_BOLD)
					{
						printf(" 75");
					}
					else
					{
						printf(" 50");
					}

					printf(" 60 su \n");
				}

				printf("%s %s/%s FT", face->family_name, argv[1], plik->d_name);

				if(face->style_flags & FT_STYLE_FLAG_ITALIC)
				{
					printf(" y");
				}
				else
				{
					printf(" n");
				}

				if(face->style_flags & FT_STYLE_FLAG_BOLD)
				{
					printf(" 75");
				}
				else
				{
					printf(" 50");
				}

				printf(" 60 su \n");

				FT_Done_Face(face);
			}
		}
	}

	return 0;
}
