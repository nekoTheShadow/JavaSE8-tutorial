package chapter8.question16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Question16 {
	public static void main(String[] args) throws IOException {
		var cities = Paths.get("cities.txt");
		var pattern = Pattern.compile("(?<city>[\\p{L} ]+),\\s*(?<state>[A-Z]{2})\\s*,\\s*(?<zip>[\\d]{9}|[\\d]{5})");
		
		Files.lines(cities).forEach(line -> {
			var matcher = pattern.matcher(line);
			if (matcher.find()) {
				var city = matcher.group("city");
				var state = matcher.group("state");
				var zip = matcher.group("zip");
				System.out.printf("city=%s, state=%s, zip=%s%n", city, state, zip);
			}
		});
	}
}

/*
city=New York, state=NY, zip=83366
city=Los Angeles, state=CA, zip=38577
city=Chicago, state=IL, zip=27148
city=Houston, state=TX, zip=21608
city=Philadelphia, state=PA, zip=15476
city=Phoenix, state=AZ, zip=14887
city=San Antonio, state=TX, zip=13829
city=San Diego, state=CA, zip=13383
city=Dallas, state=TX, zip=12411
city=San Jose, state=CA, zip=98276
city=Austin, state=TX, zip=84259
city=Jacksonville, state=FL, zip=83650
city=Indianapolis, state=IN, zip=83485
city=San Francisco, state=CA, zip=82586
city=Columbus, state=OH, zip=80979
city=Fort Worth, state=TX, zip=77799
city=Charlotte, state=NC, zip=77520
city=Detroit, state=MI, zip=70147
city=El Paso, state=TX, zip=67253
city=Memphis, state=TN, zip=65515
city=Boston, state=MA, zip=63647
city=Seattle, state=WA, zip=63453
city=Denver, state=CO, zip=63426
city=Washington, state=DC, zip=63232
city=Davidson, state=TN, zip=62449
city=Baltimore, state=MD, zip=62134
city=Jefferson County, state=KY, zip=60511
city=Portland, state=OR, zip=60310
city=Oklahoma, state=OK, zip=59919
city=Milwaukee, state=WI, zip=59891
city=Las Vegas, state=NV, zip=59642
city=Albuquerque, state=NM, zip=55541
city=Tucson, state=AZ, zip=52429
city=Fresno, state=CA, zip=50588
city=Sacramento, state=CA, zip=47551
city=Long Beach, state=CA, zip=46789
city=Kansas, state=MO, zip=46431
city=Mesa, state=AZ, zip=45208
city=Virginia Beach, state=VA, zip=44702
city=Atlanta, state=GA, zip=44377
city=Colorado Springs, state=CO, zip=43183
city=Raleigh, state=NC, zip=42317
city=Omaha, state=NE, zip=42157
city=Miami, state=FL, zip=41389
city=Oakland, state=CA, zip=40074
city=Tulsa, state=OK, zip=39398
city=Minneapolis, state=MN, zip=39288
city=Cleveland, state=OH, zip=39092
city=Wichita, state=KS, zip=38557
city=Arlington, state=TX, zip=37560
city=New Orleans, state=LA, zip=36925
city=Bakersfield, state=CA, zip=35859
city=Tampa, state=FL, zip=34764
city=Honolulu, state=HI, zip=34561
city=Anaheim, state=CA, zip=34324
city=Aurora, state=CO, zip=33903
city=Santa Ana, state=CA, zip=33092
city= Louis, state=MO, zip=31817
city=Riverside, state=CA, zip=31367
city=Corpus Christi, state=TX, zip=31219
city=Pittsburgh, state=PA, zip=30621
city=Fayette, state=KY, zip=30548
city=Anchorage, state=AK, zip=29861
city=Stockton, state=CA, zip=29798
city=Cincinnati, state=OH, zip=29655
city= Paul, state=MN, zip=29077
city=Toledo, state=OH, zip=28401
city=Newark, state=NJ, zip=27772
city=Greensboro, state=NC, zip=27708
city=Plano, state=TX, zip=27206
city=Henderson, state=NV, zip=26567
city=Lincoln, state=NE, zip=26540
city=Buffalo, state=NY, zip=25938
city=Fort Wayne, state=IN, zip=25455
city=Jersey, state=NJ, zip=25444
city=Chula Vista, state=CA, zip=25242
city=Orlando, state=FL, zip=24956
city= Petersburg, state=FL, zip=24654
city=Norfolk, state=VA, zip=24578
city=Chandler, state=AZ, zip=24562
city=Laredo, state=TX, zip=24473
city=Madison, state=WI, zip=24032
city=Durham, state=NC, zip=23935
city=Lubbock, state=TX, zip=23606
city=Salem, state=NC, zip=23434
city=Garland, state=TX, zip=23356
city=Glendale, state=AZ, zip=23214
city=Hialeah, state=FL, zip=23194
city=Reno, state=NV, zip=23102
city=Baton Rouge, state=LA, zip=23005
city=Irvine, state=CA, zip=22998
city=Chesapeake, state=VA, zip=22841
city=Irving, state=TX, zip=22542
city=Scottsdale, state=AZ, zip=22351
city=North Las Vegas, state=NV, zip=22349
city=Fremont, state=CA, zip=22198
city=Gilbert, state=AZ, zip=22114
city=San Bernardino, state=CA, zip=21329
city=Boise, state=ID, zip=21230
city=Birmingham, state=AL, zip=21203
city=Rochester, state=NY, zip=21053
city=Richmond, state=VA, zip=21030
city=Spokane, state=WA, zip=20952
city=Des Moines, state=IA, zip=20668
city=Montgomery, state=AL, zip=20529
city=Modesto, state=CA, zip=20354
city=Fayetteville, state=NC, zip=20210
city=Tacoma, state=WA, zip=20201
city=Shreveport, state=LA, zip=20186
city=Fontana, state=CA, zip=20181
city=Oxnard, state=CA, zip=20155
city=Aurora, state=IL, zip=19993
city=Moreno Valley, state=CA, zip=19955
city=Akron, state=OH, zip=19854
city=Yonkers, state=NY, zip=19844
city=Columbus, state=GA, zip=19841
city=Richmond County, state=GA, zip=19787
city=Little Rock, state=AR, zip=19653
city=Amarillo, state=TX, zip=19525
city=Mobile, state=AL, zip=19482
city=Huntington Beach, state=CA, zip=19470
city=Glendale, state=CA, zip=19447
city=Grand Rapids, state=MI, zip=19041
city=Salt Lake, state=UT, zip=18931
city=Tallahassee, state=FL, zip=18697
city=Huntsville, state=AL, zip=18373
city=Worcester, state=MA, zip=18266
city=Knoxville, state=TN, zip=18220
city=Grand Prairie, state=TX, zip=18182
city=Newport News, state=VA, zip=18072
city=Brownsville, state=TX, zip=18009
city=Santa Clarita, state=CA, zip=17901
city=Overland Park, state=KS, zip=17891
city=Providence, state=RI, zip=17843
city=Jackson, state=MS, zip=17543
city=Garden Grove, state=CA, zip=17438
city=Oceanside, state=CA, zip=17129
city=Chattanooga, state=TN, zip=17127
city=Fort Lauderdale, state=FL, zip=17074
city=Rancho Cucamonga, state=CA, zip=17074
city=Santa Rosa, state=CA, zip=17068
city= Lucie, state=FL, zip=16871
city=Ontario, state=CA, zip=16721
city=Tempe, state=AZ, zip=16684
city=Vancouver, state=WA, zip=16548
city=Springfield, state=MO, zip=16219
city=Cape Coral, state=FL, zip=16124
city=Pembroke Pines, state=FL, zip=16030
city=Sioux Falls, state=SD, zip=15990
city=Peoria, state=AZ, zip=15978
city=Lancaster, state=CA, zip=15905
city=Elk Grove, state=CA, zip=15903
city=Corona, state=CA, zip=15839
city=Eugene, state=OR, zip=15798
city=Salem, state=OR, zip=15742
city=Palmdale, state=CA, zip=15565
city=Salinas, state=CA, zip=15448
city=Springfield, state=MA, zip=15355
city=Pasadena, state=TX, zip=15227
city=Rockford, state=IL, zip=15084
city=Pomona, state=CA, zip=15081
city=Hayward, state=CA, zip=14939
city=Fort Collins, state=CO, zip=14861
city=Joliet, state=IL, zip=14826
city=Escondido, state=CA, zip=14757
city=Kansas, state=KS, zip=14726
city=Torrance, state=CA, zip=14702
city=Bridgeport, state=CT, zip=14642
city=Alexandria, state=VA, zip=14629
city=Sunnyvale, state=CA, zip=14619
city=Cary, state=NC, zip=14569
city=Lakewood, state=CO, zip=14551
city=Hollywood, state=FL, zip=14523
city=Paterson, state=NJ, zip=14521
city=Syracuse, state=NY, zip=14417
city=Naperville, state=IL, zip=14368
city=McKinney, state=TX, zip=14322
city=Mesquite, state=TX, zip=14319
city=Clarksville, state=TN, zip=14251
city=Savannah, state=GA, zip=14202
city=Dayton, state=OH, zip=14135
city=Orange, state=CA, zip=13941
city=Fullerton, state=CA, zip=13857
city=Pasadena, state=CA, zip=13854
city=Hampton, state=VA, zip=13683
city=McAllen, state=TX, zip=13471
city=Killeen, state=TX, zip=13465
city=Warren, state=MI, zip=13414
city=West Valley, state=UT, zip=13243
city=Columbia, state=SC, zip=13168
city=New Haven, state=CT, zip=13074
city=Sterling Heights, state=MI, zip=13041
city=Olathe, state=KS, zip=13004
city=Miramar, state=FL, zip=12872
city=Thousand Oaks, state=CA, zip=12841
city=Frisco, state=TX, zip=12817
city=Cedar Rapids, state=IA, zip=12811
city=Topeka, state=KS, zip=12793
city=Visalia, state=CA, zip=12708
city=Waco, state=TX, zip=12701
city=Elizabeth, state=NJ, zip=12645
city=Bellevue, state=WA, zip=12643
city=Gainesville, state=FL, zip=12604
city=Simi Valley, state=CA, zip=12579
city=Charleston, state=SC, zip=12558
city=Carrollton, state=TX, zip=12540
city=Coral Springs, state=FL, zip=12528
city=Stamford, state=CT, zip=12510
city=Hartford, state=CT, zip=12489
city=Concord, state=CA, zip=12471
city=Roseville, state=CA, zip=12451
city=Thornton, state=CO, zip=12414
city=Kent, state=WA, zip=12299
city=Lafayette, state=LA, zip=12276
city=Surprise, state=AZ, zip=12128
city=Denton, state=TX, zip=12112
city=Victorville, state=CA, zip=12033
city=Evansville, state=IN, zip=12023
city=Midland, state=TX, zip=11938
city=Santa Clara, state=CA, zip=11931
city=Clarke County, state=GA, zip=11899
city=Allentown, state=PA, zip=11897
city=Abilene, state=TX, zip=11888
city=Beaumont, state=TX, zip=11822
city=Vallejo, state=CA, zip=11779
city=Independence, state=MO, zip=11727
city=Springfield, state=IL, zip=11712
city=Ann Arbor, state=MI, zip=11612
city=Provo, state=UT, zip=11591
city=Peoria, state=IL, zip=11568
city=Norman, state=OK, zip=11556
city=Berkeley, state=CA, zip=11540
city=El Monte, state=CA, zip=11511
city=Murfreesboro, state=TN, zip=11403
city=Lansing, state=MI, zip=11399
city=Columbia, state=MO, zip=11322
city=Downey, state=CA, zip=11287
city=Costa Mesa, state=CA, zip=11191
city=Inglewood, state=CA, zip=11118
city=Miami Gardens, state=FL, zip=11075
city=Manchester, state=NH, zip=11020
city=Elgin, state=IL, zip=10992
city=Wilmington, state=NC, zip=10992
city=Waterbury, state=CT, zip=10991
city=Fargo, state=ND, zip=10977
city=Arvada, state=CO, zip=10974
city=Carlsbad, state=CA, zip=10931
city=Westminster, state=CO, zip=10916
city=Rochester, state=MN, zip=10899
city=Gresham, state=OR, zip=10895
city=Clearwater, state=FL, zip=10873
city=Lowell, state=MA, zip=10852
city=West Jordan, state=UT, zip=10838
city=Pueblo, state=CO, zip=10777
city=Fairfield, state=CA, zip=10768
city=West Covina, state=CA, zip=10744
city=Billings, state=MO, zip=10695
city=Murrieta, state=CA, zip=10681
city=High Point, state=NC, zip=10658
city=Round Rock, state=TX, zip=10657
city=Richmond, state=CA, zip=10651
city=Cambridge, state=MA, zip=10647
city=Norwalk, state=CA, zip=10627
city=Odessa, state=TX, zip=10610
city=Antioch, state=CA, zip=10550
city=Temecula, state=CA, zip=10520
city=Green Bay, state=WI, zip=10486
city=Everett, state=WA, zip=10465
city=Wichita Falls, state=TX, zip=10455
city=Burbank, state=CA, zip=10439
city=Palm Bay, state=FL, zip=10412
city=Centennial, state=CO, zip=10374
city=Daly, state=CA, zip=10369
city=Richardson, state=TX, zip=10329
city=Pompano Beach, state=FL, zip=10298
city=Broken Arrow, state=OK, zip=10201
city=North Charleston, state=SC, zip=10198
city=West Palm Beach, state=FL, zip=10190
city=Boulder, state=CO, zip=10180
city=Rialto, state=CA, zip=10174
city=Santa Maria, state=CA, zip=10145
city=El Cajon, state=CA, zip=10143
city=Davenport, state=IA, zip=10136
city=Las Cruces, state=NM, zip=10104
city=Erie, state=PA, zip=10104
city=South Bend, state=IN, zip=10080
city=Flint, state=MI, zip=10051
city=Kenosha, state=WI, zip=10015
city=Lakeland, state=FL, zip=99999
city=San Mateo, state=CA, zip=99670
city=Lewisville, state=TX, zip=99453
city=Sandy Springs, state=GA, zip=99419
city=Tyler, state=TX, zip=99323
city=Clovis, state=CA, zip=98632
city=Lawton, state=OK, zip=98376
city=Albany, state=NY, zip=97904
city=College Station, state=TX, zip=97801
city=Compton, state=CA, zip=97559
city=Roanoke, state=VA, zip=97469
city=Jurupa Valley, state=CA, zip=97426
city=Dearborn, state=MI, zip=96474
city=Portsmouth, state=VA, zip=96470
city=Pearland, state=TX, zip=96294
city=Vista, state=CA, zip=96047
city=San Angelo, state=TX, zip=95887
city=Livonia, state=MI, zip=95586
city=Davie, state=FL, zip=95489
city=Renton, state=WA, zip=95448
city=Yuma, state=AZ, zip=95429
city=Greeley, state=CO, zip=95357
city=Hillsboro, state=OR, zip=95327
city=South Gate, state=CA, zip=95304
city=Mission Viejo, state=CA, zip=95290
city=New Bedford, state=MA, zip=94929
city=Brockton, state=MA, zip=94094
city=Vacaville, state=CA, zip=93899
city=Roswell, state=GA, zip=93692
city=Tuscaloosa, state=AL, zip=93357
city=Yakima, state=WA, zip=93101
city=Quincy, state=MA, zip=93027
city=Carson, state=CA, zip=93002
city=Beaverton, state=OR, zip=92680
city=s Summit, state=MO, zip=92468
city=Sparks, state=NV, zip=92183
city=Hesperia, state=CA, zip=92062
city=Federal Way, state=WA, zip=91933
city=Santa Monica, state=CA, zip=91812
city=Westminster, state=CA, zip=91377
city=Lynn, state=MA, zip=91253
city=Macon, state=GA, zip=91234
city=Rio Rancho, state=NM, zip=90818
city=Redding, state=CA, zip=90755
city=Orem, state=UT, zip=90749
city=Spokane Valley, state=WA, zip=90641
city=Miami Beach, state=FL, zip=90588
city=Allen, state=TX, zip=89640
city=Santa Barbara, state=CA, zip=89639
city=Lawrence, state=KS, zip=89512
city=Sandy, state=UT, zip=89344
city=Fall River, state=MA, zip=88945
city=Waukegan, state=IL, zip=88862
city=Sunrise, state=FL, zip=88843
city=Longmont, state=CO, zip=88669
city=League, state=TX, zip=88188
city=Reading, state=PA, zip=88102
city=Plantation, state=FL, zip=88016
city=Boca Raton, state=FL, zip=87836
city=Chico, state=CA, zip=87714
city=Fort Smith, state=AR, zip=87443
city=Greenville, state=NC, zip=87242
city=Norwalk, state=CT, zip=87190
city=Newport Beach, state=CA, zip=87068
city=Nashua, state=NH, zip=86933
city=San Leandro, state=CA, zip=86890
city=San Marcos, state=CA, zip=86752
city=Newton, state=MA, zip=86307
city=Duluth, state=MN, zip=86211
city=Whittier, state=CA, zip=86177
city=Bloomington, state=MN, zip=86033
city=Asheville, state=NC, zip=85712
city=Hawthorne, state=CA, zip=85681
city=Deltona, state=FL, zip=85442
city=Suffolk, state=VA, zip=85181
city=Edmond, state=OK, zip=84885
city=Citrus Heights, state=CA, zip=84870
city=Clifton, state=NJ, zip=84722
city=Tracy, state=CA, zip=84669
city=Trenton, state=NJ, zip=84477
city=Alhambra, state=CA, zip=84322
city=Cicero, state=IL, zip=84137
city=Nampa, state=ID, zip=83930
city=Ogden, state=UT, zip=83793
city=Carmel, state=IN, zip=83565
city=Livermore, state=CA, zip=83547
city=Hoover, state=AL, zip=83412
city=Westland, state=MI, zip=82883
city=Danbury, state=CT, zip=82807
city=Sioux, state=IA, zip=82719
city=Champaign, state=IL, zip=82517
city=Sugar Land, state=TX, zip=82480
city=Johns Creek, state=GA, zip=82306
city=Bellingham, state=WA, zip=82234
city=Troy, state=MI, zip=82212
city=Buena Park, state=CA, zip=82155
city=Concord, state=NC, zip=81981
city=Fallon, state=MO, zip=81979
city=Bloomington, state=IN, zip=81963
city=Warwick, state=RI, zip=81873
city=Fishers, state=IN, zip=81833
city=Menifee, state=CA, zip=81474
city=Longview, state=TX, zip=81092
city=Hemet, state=CA, zip=81046
city=Edinburg, state=TX, zip=81029
city=Lakewood, state=CA, zip=80833
city=Merced, state=CA, zip=80793
city=Farmington Hills, state=MI, zip=80756
city=Parma, state=OH, zip=80597
city=Cranston, state=RI, zip=80529
city=Mission, state=TX, zip=80452
city=Meridian, state=ID, zip=80386
city=Chino, state=CA, zip=80164
city=Hammond, state=IN, zip=79686
city=Indio, state=CA, zip=79302
city=Gary, state=IN, zip=79170
city=Bend, state=OR, zip=79109
city=Redwood, state=CA, zip=79009
city=Lake Forest, state=CA, zip=78853
city=New Rochelle, state=NY, zip=78388
city=Napa, state=CA, zip=78340
city=Racine, state=WI, zip=78303
city=Avondale, state=AZ, zip=78256
city=Bryan, state=TX, zip=78061
city=Tustin, state=CA, zip=78049
city=Largo, state=FL, zip=77878
city=Brooklyn Park, state=MN, zip=77752
city=Bloomington, state=IL, zip=77733
city=Deerfield Beach, state=FL, zip=77439
city=Albany, state=GA, zip=77431
city=Palm Coast, state=FL, zip=77374
city=Bellflower, state=CA, zip=77356
city=Lawrence, state=MA, zip=77326
city=Camden, state=NJ, zip=77250
city= Joseph, state=MO, zip=77176
city=Lynchburg, state=VA, zip=77113
city=Somerville, state=MA, zip=77104
city=Melbourne, state=FL, zip=77048
city=Fayetteville, state=AR, zip=76899
city=Mountain View, state=CA, zip=76621
city=Medford, state=OR, zip=76462
city=Chino Hills, state=CA, zip=76457
city=Baldwin Park, state=CA, zip=76419
city=Kennewick, state=WA, zip=75971
city=Scranton, state=PA, zip=75809
city=Arlington Heights, state=IL, zip=75777
city=Alameda, state=CA, zip=75641
city= George, state=UT, zip=75561
city=Evanston, state=IL, zip=75430
city=Decatur, state=IL, zip=75407
city=Upland, state=CA, zip=75209
city=Bethlehem, state=PA, zip=75103
city=Kalamazoo, state=MI, zip=75092
city=Schaumburg, state=IL, zip=74781
city=Bolingbrook, state=IL, zip=74039
city=San Ramon, state=CA, zip=73927
city=Auburn, state=WA, zip=73505
city=Lake Charles, state=LA, zip=73474
city=Folsom, state=CA, zip=73384
city=Wyoming, state=MI, zip=73371
city=Baytown, state=TX, zip=73238
city=New Britain, state=CT, zip=73153
city=Pharr, state=TX, zip=73138
city=Springdale, state=AR, zip=73123
city=Appleton, state=WI, zip=73016
city=Plymouth, state=MN, zip=72928
city=Gastonia, state=NC, zip=72723
city=Canton, state=OH, zip=72683
city=Southfield, state=MI, zip=72507
city=Pleasanton, state=CA, zip=72338
city=Rochester Hills, state=MI, zip=72283
city=Mount Pleasant, state=SC, zip=71875
city=Union, state=CA, zip=71763
city=Perris, state=CA, zip=71326
city=Wilmington, state=DE, zip=71292
city=Pawtucket, state=RI, zip=71170
city=Manteca, state=CA, zip=71067
city=Waukesha, state=WI, zip=70920
city=Warner Robins, state=GA, zip=70712
city=Lynwood, state=CA, zip=70709
city=Apple Valley, state=CA, zip=70700
city=Loveland, state=CO, zip=70223
city=Passaic, state=NJ, zip=70218
city=Jonesboro, state=AR, zip=70187
city=Iowa, state=IA, zip=70133
city=Gulfport, state=MS, zip=70113
city=Boynton Beach, state=FL, zip=70101
city=Muncie, state=IN, zip=70087
city=Redlands, state=CA, zip=69916
city=Rapid, state=SD, zip=69854
city=Turlock, state=CA, zip=69733
city=Goodyear, state=AZ, zip=69648
city=Jacksonville, state=NC, zip=69220
city=Santa Fe, state=NM, zip=69204
city=Temple, state=TX, zip=69148
city=Palatine, state=IL, zip=69144
city=Lauderhill, state=FL, zip=69100
city=Missouri, state=TX, zip=69020
city=Milpitas, state=CA, zip=68800
city=Layton, state=UT, zip=68677
city=Missoula, state=MO, zip=68394
city=Waterloo, state=IA, zip=68297
city=Rock Hill, state=SC, zip=68094
city=Lafayette, state=IN, zip=67925
city=Mount Vernon, state=NY, zip=67896
city=Flower Mound, state=TX, zip=67825
city=Union, state=NJ, zip=67744
city=Redondo Beach, state=CA, zip=67693
city=Weston, state=FL, zip=67641
city=Flagstaff, state=AZ, zip=67468
city=Dothan, state=AL, zip=67382
city=Jackson, state=TN, zip=67265
city=Rancho Cordova, state=CA, zip=66997
city=Eau Claire, state=WI, zip=66966
city=Kenner, state=LA, zip=66820
city=Yorba Linda, state=CA, zip=66735
city=Oshkosh, state=WI, zip=66653
city= Charles, state=MO, zip=66463
city=Frederick, state=MD, zip=66382
city=Palo Alto, state=CA, zip=66363
city=Franklin, state=TN, zip=66280
city=Portland, state=ME, zip=66214
city=Schenectady, state=NY, zip=66078
city=Davis, state=CA, zip=65993
city= Cloud, state=MN, zip=65986
city=Camarillo, state=CA, zip=65968
city=Fort Myers, state=FL, zip=65725
city=Walnut Creek, state=CA, zip=65695
city=Harlingen, state=TX, zip=65679
city=Pittsburg, state=CA, zip=65664
city=South San Francisco, state=CA, zip=65547
city=Youngstown, state=OH, zip=65405
city=Pasco, state=WA, zip=65398
city=North Richland Hills, state=TX, zip=65290
city=Yuba, state=CA, zip=65105
city=Skokie, state=IL, zip=65074
city=San Clemente, state=CA, zip=64882
city=Eagan, state=MN, zip=64854
city=Bismarck, state=ND, zip=64751
city=Bossier, state=LA, zip=64655
city=North Little Rock, state=AR, zip=64633
city=Johnson, state=TN, zip=64528
city=Woodbury, state=MN, zip=64496
city=Laguna Niguel, state=CA, zip=64452
city=Maple Grove, state=MN, zip=64420
city=Bayonne, state=NJ, zip=64416
city=Victoria, state=TX, zip=64376
city=East Orange, state=NJ, zip=64268
city=Lorain, state=OH, zip=63707
city=Shawnee, state=KS, zip=63622
city=Janesville, state=WI, zip=63588
city=Pico Rivera, state=CA, zip=63522
city=Kissimmee, state=FL, zip=63369
city=Montebello, state=CA, zip=63305
city=Lodi, state=CA, zip=63301
city=Rockville, state=MD, zip=63244
city=Homestead, state=FL, zip=63190
city=Conway, state=AR, zip=62939
city=Gaithersburg, state=MD, zip=62794
city=Madera, state=CA, zip=62624
city=Tamarac, state=FL, zip=62557
city=Marysville, state=WA, zip=62402
city=Delray Beach, state=FL, zip=62357
city=Hamilton, state=OH, zip=62295
city=Eden Prairie, state=MN, zip=62258
city=Council Bluffs, state=IA, zip=62115
city=Taylor, state=MI, zip=62114
city=Santa Cruz, state=CA, zip=62041
city=Daytona Beach, state=FL, zip=62035
city=Alpharetta, state=GA, zip=61981
city=Coon Rapids, state=MN, zip=61931
city=Waltham, state=MA, zip=61918
city=Utica, state=NY, zip=61822
city=Haverhill, state=MA, zip=61797
city=Cheyenne, state=WY, zip=61537
city=Conroe, state=TX, zip=61533
city=La Habra, state=CA, zip=61392
city=Burnsville, state=MN, zip=61130
city=Terre Haute, state=IN, zip=61112
city=Encinitas, state=CA, zip=60994
city=Monterey Park, state=CA, zip=60937
city=Tulare, state=CA, zip=60933
city=Vineland, state=NJ, zip=60854
city=New Braunfels, state=TX, zip=60761
city=West Allis, state=WI, zip=60732
city=Greenville, state=SC, zip=60709
city=Meriden, state=CT, zip=60638
city=Ames, state=IA, zip=60634
city=Bristol, state=CT, zip=60603
city=Bowling Green, state=KY, zip=60600
city=North Miami, state=FL, zip=60565
city=Malden, state=MA, zip=60374
city=Taylorsville, state=UT, zip=60227
city=Pontiac, state=MI, zip=60175
city=Springfield, state=OH, zip=60147
city=Cupertino, state=CA, zip=60009
city=Grand Junction, state=CO, zip=59899
city=Springfield, state=OR, zip=59869
city= Clair Shores, state=MI, zip=59749
city=Gardena, state=CA, zip=59490
city=Blaine, state=MN, zip=59412
city=National, state=CA, zip=59387
city=Lancaster, state=PA, zip=59360
city=Mansfield, state=TX, zip=59317
city=West Des Moines, state=IA, zip=59296
city=Rocklin, state=CA, zip=59030
city=Petaluma, state=CA, zip=58921
city=Rogers, state=AR, zip=58895
city=Great Falls, state=MO, zip=58893
city=Lakewood, state=WA, zip=58852
city=Des Plaines, state=IL, zip=58840
city=Wellington, state=FL, zip=58679
city=Huntington Park, state=CA, zip=58673
city=San Rafael, state=CA, zip=58502
city=Chapel Hill, state=NC, zip=58424
city=Royal Oak, state=MI, zip=58410
city=North Port, state=FL, zip=58378
city=Marietta, state=GA, zip=58359
city=Broomfield, state=CO, zip=58298
city=La Mesa, state=CA, zip=58160
city=Dubuque, state=IA, zip=58155
city=Owensboro, state=KY, zip=58083
city=Cedar Park, state=TX, zip=57957
city=Idaho Falls, state=ID, zip=57899
city=Casper, state=WY, zip=57813
city=Moore, state=OK, zip=57810
city=Rowlett, state=TX, zip=57703
city=Valdosta, state=GA, zip=57597
city=Arcadia, state=CA, zip=57497
city=White Plains, state=NY, zip=57403
city=Orland Park, state=IL, zip=57392
city=Lakeville, state=MN, zip=57342
city=Jupiter, state=FL, zip=57221
city=Tinley Park, state=IL, zip=57144
city=Rocky Mount, state=NC, zip=57136
city=Medford, state=MA, zip=57033
city=Oak Lawn, state=IL, zip=56995
city=Ocala, state=FL, zip=56945
city=Novi, state=MI, zip=56912
city=Auburn, state=AL, zip=56908
city=Kokomo, state=IN, zip=56866
city=Dearborn Heights, state=MI, zip=56838
city=Berwyn, state=IL, zip=56800
city=Port Orange, state=FL, zip=56766
city=Redmond, state=WA, zip=56561
city=Fountain Valley, state=CA, zip=56464
city=Diamond Bar, state=CA, zip=56363
city=Woodland, state=CA, zip=56271
city=New Brunswick, state=NJ, zip=56160
city=Bowie, state=MD, zip=56129
city=Midwest, state=OK, zip=56080
city=Manhattan, state=KS, zip=56069
city=Taunton, state=MA, zip=56055
city=Decatur, state=AL, zip=55996
city=Kettering, state=OH, zip=55990
city=Bartlett, state=TN, zip=55945
city=South Jordan, state=UT, zip=55934
city=Anderson, state=IN, zip=55554
city=Chicopee, state=MA, zip=55490
city=West Haven, state=CT, zip=55404
city=Santee, state=CA, zip=55343
city=Lake Elsinore, state=CA, zip=55288
city=Noblesville, state=IN, zip=55075
city=Margate, state=FL, zip=55026
city=Porterville, state=CA, zip=55023
city=Coconut Creek, state=FL, zip=55001
city=Corvallis, state=OR, zip=54998
city=Weymouth, state=MA, zip=54906
city=Hempstead, state=NY, zip=54883
city=Carson, state=NV, zip=54838
city=Pocatello, state=ID, zip=54777
city=Paramount, state=CA, zip=54680
city=Sanford, state=FL, zip=54651
city=Eastvale, state=CA, zip=54635
city=Buckeye, state=AZ, zip=54542
city=Mount Prospect, state=IL, zip=54505
city=Rosemead, state=CA, zip=54393
city=Shoreline, state=WA, zip=54352
city=Hanford, state=CA, zip=54324
city=Highland, state=CA, zip=54154
city=Elyria, state=OH, zip=54086
city= Peters, state=MO, zip=54078
city=Port Arthur, state=TX, zip=54010
city=Normal, state=IL, zip=53837
city=Brentwood, state=CA, zip=53673
city=Wheaton, state=IL, zip=53469
city=Grand Forks, state=ND, zip=53456
city=Novato, state=CA, zip=53301
city=Revere, state=MA, zip=53179
city=Colton, state=CA, zip=53123
city=Hendersonville, state=TN, zip=53080
city=Blue Springs, state=MO, zip=53014
city=Lake Havasu, state=AZ, zip=52819
city=Sarasota, state=FL, zip=52811
city=Euless, state=TX, zip=52780
city=Cathedral, state=CA, zip=52655
city=Greenwood, state=IN, zip=52652
city=Smyrna, state=GA, zip=52650
city=Bellevue, state=NE, zip=52604
city=Delano, state=CA, zip=52426
city=Pensacola, state=FL, zip=52340
city=Hoffman Estates, state=IL, zip=52305
city=Georgetown, state=TX, zip=52303
city=Yucaipa, state=CA, zip=52265
city=Florissant, state=MO, zip=52252
city=Hoboken, state=NJ, zip=52034
city=Oak Park, state=IL, zip=52015
city=Battle Creek, state=MI, zip=51911
city=Pflugerville, state=TX, zip=51894
city=Watsonville, state=CA, zip=51881
city=Peabody, state=MA, zip=51867
city=Perth Amboy, state=NJ, zip=51744
city=Placentia, state=CA, zip=51673
city=La Crosse, state=WI, zip=51647
city=Kingsport, state=TN, zip=51501
city=Milford, state=CT, zip=51488
city=West NY, state=NJ, zip=51464
city=Richland, state=WA, zip=51440
city=Lakewood, state=OH, zip=51385
city=Castle Rock, state=CO, zip=51348
city=Albany, state=OR, zip=51322
city=Burlington, state=NC, zip=51306
city=Lehi, state=UT, zip=51173
city=Elkhart, state=IN, zip=51152
city=Minnetonka, state=MN, zip=51123
city=DeSoto, state=TX, zip=51102
city=Charleston, state=WV, zip=51018
city=Harrisonburg, state=VA, zip=50981
city=Saginaw, state=MI, zip=50790
city=Glendora, state=CA, zip=50719
city=Kirkland, state=WA, zip=50697
city=Bradenton, state=FL, zip=50672
city=Gilroy, state=CA, zip=50660
city=Southaven, state=MS, zip=50374
city=Plainfield, state=NJ, zip=50244
city=Palm Desert, state=CA, zip=50013
city=San Marcos, state=TX, zip=50001
city=Troy, state=NY, zip=49946
city=Niagara Falls, state=NY, zip=49722
city=Joplin, state=MO, zip=49526
*/