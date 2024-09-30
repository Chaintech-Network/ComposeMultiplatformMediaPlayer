package org.chaintech.app.model

import chaintech.videoplayer.model.AudioFile
import org.chaintech.app.utility.getLocalFilePathFor

class MockData {

    val bottomAddBanner = "https://v3img.voot.com/resizeMedium,w_2304,h_493/v3Storage/assets/newseasonmotu14x3nonewsseason-1714503970736.jpg"
    val topAddBanner = "https://v3img.voot.com/resizeMedium,w_2304,h_493/v3Storage/assets/flash-14x3-1699990763334.jpg"
    val detailBanner = "https://v3img.voot.com/resizeMedium,w_2304,h_493/v3Storage/assets/14x3dsk-1722539359934.jpg"

    val reelsUrlArray = listOf(
        "https://user-images.githubusercontent.com/90382113/170887700-e405c71e-fe31-458d-8572-aea2e801eecc.mp4",
        "https://user-images.githubusercontent.com/90382113/170885742-d82e3b59-e45a-4fcf-a851-fed58ff5a690.mp4",
        "https://user-images.githubusercontent.com/90382113/170888784-5d9a7623-10c8-4ca2-8585-fdb29b2ed037.mp4",
        "https://user-images.githubusercontent.com/90382113/170889265-7ed9a56c-dd5f-4d78-b453-18b011644da0.mp4",
        "https://user-images.githubusercontent.com/90382113/170890384-43214cc8-79c6-4815-bcb7-e22f6f7fe1bc.mp4"
    )


    val audioFilesArray = listOf(
        AudioFile(
            getLocalFilePathFor("Believer.mp3"),
            audioTitle = "Believer (From Local Storage)"
        ),
        AudioFile(
            audioUrl = "https://codeskulptor-demos.commondatastorage.googleapis.com/GalaxyInvaders/theme_01.mp3",
            audioTitle = "Galaxy Invaders",
            thumbnailUrl = "https://c.saavncdn.com/866/On-My-Way-English-2019-20190308195918-500x500.jpg"
        ),
        AudioFile(
            audioUrl = "https://codeskulptor-demos.commondatastorage.googleapis.com/pang/paza-moduless.mp3",
            audioTitle = "Paza Moduless"
        ),
        AudioFile(
            audioUrl = "https://commondatastorage.googleapis.com/codeskulptor-demos/DDR_assets/Kangaroo_MusiQue_-_The_Neverwritten_Role_Playing_Game.mp3",
            audioTitle = "The Neverwritten Role PlayingGame",
            thumbnailUrl = "https://c.saavncdn.com/464/Indigo-Extended--English-2019-20191004165519-500x500.jpg"
        ),
        AudioFile(
            audioUrl = "https://commondatastorage.googleapis.com/codeskulptor-demos/DDR_assets/Sevish_-__nbsp_.mp3",
            audioTitle = "Sevish"
        )
    )

    val mockData = listOf(
            VideoModel(
                id = "1",
                description = "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself.",
                sources = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                subtitle = "By Blender Foundation",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/aquaman_3x4-1685448020016.jpg",
                title = "Big Buck Bunny",
                duration = "9 min 56 s",
                rating = "4",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/inception-tv-1697699284926.jpg"
            ),
            VideoModel(
                id = "2",
                description = "The first Blender Open Movie from 2006",
                sources = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                subtitle = "By Blender Foundation",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1707191348650.jpg",
                title = "Elephant Dream",
                duration = "10 min 53 s",
                rating = "5",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/mad-max--fury-road--tv-1698657374548.jpg"
            ),
            VideoModel(
                id = "3",
                description = "HBO GO now works with Chromecast -- the easiest way to enjoy online video on your TV.",
                sources = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4" ,
                subtitle = "By Google",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/dunkirk-3x4-1685712551831.jpg",
                title = "For Bigger Blazes",
                duration = "14 s",
                rating = "4.5",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/godzilla-king-of-the-monsterstv-1697885255069.jpg"
            ),
            VideoModel(
                id = "4",
                description = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for when Batman's escapes aren't quite big enough. ",
                sources = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4" ,
                subtitle = "By Google",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/hp6_3x4-1687867758365.jpg",
                title = "For Bigger Escape",
                duration = "15 s",
                rating = "3",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/evil-dead-rise-tv-2-1697432060944.jpg"
            ),
            VideoModel(
                id = "5",
                description = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV. For $35.  Find out more at google.com/chromecast.",
                sources =  "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4" ,
                subtitle = "By Google",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1708145297782.jpg",
                title = "For Bigger Fun",
                duration = "1 min",
                rating = "5",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/puss-in-boots-tv-1696331422101.jpg"
            ),
            VideoModel(
                id = "6",
                description = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for the times that call for bigger joyrides. For $35. Learn how to use Chromecast with YouTube and more at google.com/chromecast.",
                sources =  "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4" ,
                subtitle = "By Google",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/hangover_3x4-1686200517765.jpg",
                title = "For Bigger Joyrides",
                duration = "15 s",
                rating = "4",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/vertical-carousel-tv-1717431474775.jpg"
            ),
            VideoModel(
                id = "7",
                description ="Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for when you want to make Buster's big meltdowns even bigger. For $35. Learn how to use Chromecast with Netflix and more at google.com/chromecast.",
                sources =  "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4" ,
                subtitle = "By Google",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/theintern-3x4-1686484570836.jpg",
                title = "For Bigger Meltdowns",
                duration = "15 s",
                rating = "4",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/the-dark-knight-tv-1696338828687.jpg"
            ),
            VideoModel(
                id = "8",
                description = "Sintel is an independently produced short film, initiated by the Blender Foundation as a means to further improve and validate the free/open source 3D creation suite Blender. With initial funding provided by 1000s of donations via the internet community, it has again proven to be a viable development model for both open 3D technology as for independent animation film.\nThis 15 minute film has been realized in the studio of the Amsterdam Blender Institute, by an international team of artists and developers. In addition to that, several crucial technical and creative targets have been realized online, by developers and artists and teams all over the world.\nwww.sintel.org",
                sources =  "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4" ,
                subtitle = "By Blender Foundation",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/funnypeople-3x4-1686899522715.jpg",
                title = "Sintel",
                duration = "14 min 47 s",
                rating = "4",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/flash-tv-1699991069563.jpg"
            ),
            VideoModel(
                id = "9",
                description = "Smoking Tire takes the all-new Subaru Outback to the highest point we can find in hopes our customer-appreciation Balloon Launch will get some free T-shirts into the hands of our viewers.",
                sources =  "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4" ,
                subtitle = "By Garage419",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1701247349405.jpg",
                title = "Subaru Outback On Street And Dirt",
                duration = "2 hr 10 min",
                rating = "4",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/vertical-carousel-tv-1714658980641.jpg"
            ),
            VideoModel(
                id = "10",
                description = "Tears of Steel was realized with crowd-funding by users of the open source 3D creation tool Blender. Target was to improve and test a complete open and free pipeline for visual effects in film - and to make a compelling sci-fi film in Amsterdam, the Netherlands.  The film itself, and all raw material used for making it, have been released under the Creatieve Commons 3.0 Attribution license. Visit the tearsofsteel.org website to find out more about this, or to purchase the 4-DVD box with a lot of extras.  (CC) Blender Foundation - http://www.tearsofsteel.org",
                sources =  "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4" ,
                subtitle = "By Blender Foundation",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/oppenheimer-3x4-1712046716651.jpg",
                title = "Tears of Steel",
                duration = "2 hr 10 min",
                rating = "4",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/vertical-carousel-tv-1703659873046.jpg"
            ),
            VideoModel(
                id = "11",
                description = "The Smoking Tire heads out to Adams Motorsports Park in Riverside, CA to test the most requested car of 2010, the Volkswagen GTI. Will it beat the Mazdaspeed3's standard-setting lap time? Watch and see...",
                sources =  "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4" ,
                subtitle = "By Garage419",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/shazam-fury-of-the-gods-3x4-1698688392769.jpg",
                title = "Volkswagen GTI Review",
                duration = "2 hr 10 min",
                rating = "4",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/vertical-tv-1723182567870.jpg"
            ),
            VideoModel(
                id = "12",
                description = "The Smoking Tire is going on the 2010 Bullrun Live Rally in a 2011 Shelby GT500, and posting a video from the road every single day!",
                sources =  "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4" ,
                subtitle = "By Garage419",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1709006719984.jpg",
                title = "We Are Going On Bullrun",
                duration = "2 hr 10 min",
                rating = "4",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_512/v3Storage/assets/kong-skull-island-mobile-1696657717045.jpg"
            ),
            VideoModel(
                id = "13",
                description = "The Smoking Tire meets up with Chris and Jorge from CarsForAGrand.com to see just how far $1,000 can go when looking for a car.",
                sources =  "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4" ,
                subtitle = "By Garage419",
                thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1717082469138.jpg",
                title = "What care can you get for a grand?",
                duration = "1 hr 10 min",
                rating = "4",
                thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_512/v3Storage/assets/aquaman-mobile-1696657559914.jpg"
            ),
        )

    val youtbeMockData = listOf(
        VideoModel(
            id = "1",
            description = "",
            sources = "https://www.youtube.com/watch?v=8hP9D6kZseM",
            subtitle = "BoxOfficeSmashers",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/inception_3x4-1685712225537.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/inception-tv-1697699284926.jpg",
            title = "Inception - Official Trailer",
            duration = "",
            rating = "3.1M",
            date = "9 year ago"
        ),
        VideoModel(
            id = "2",
            description = "",
            sources = "https://www.youtube.com/watch?v=YWNWi-ZWL3c",
            subtitle = "Warner Bros. Pictures",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/mad-max-fury-road-3x4-1685449047400.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/mad-max--fury-road--tv-1698657374548.jpg",
            title = "Mad Max: Fury Road",
            duration = "",
            rating = "5M",
            date = "10 days ago"
        ),
        VideoModel(
            id = "3",
            description = "",
            sources = "https://www.youtube.com/watch?v=QFxN2oDKk0E",
            subtitle = "Warner Bros. Pictures",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/godzilla-king-of-the-monsters-3x4-1685527991115.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/godzilla-king-of-the-monsterstv-1697885255069.jpg",
            title = "Godzilla: King of the Monsters",
            duration = "",
            rating = "2M",
            date = "6 month ago"
        ),
        VideoModel(
            id = "4",
            description = "",
            sources = "https://www.youtube.com/watch?v=smTK_AeAPHs",
            subtitle = "StudiocanalUK",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/evil-dead-rise-3x4-1698688439226.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/evil-dead-rise-tv-2-1697432060944.jpg",
            title = "EVIL DEAD RISE",
            duration = "",
            rating = "20M",
            date = "5 year ago"
        ),
        VideoModel(
            id = "5",
            description = "",
            sources = "https://www.youtube.com/watch?v=RqrXhwS33yc",
            subtitle = "Universal Pictures",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/puss-in-boots-the-last-wish-3x4-1685358468713.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/puss-in-boots-tv-1696331422101.jpg",
            title = "Puss In Boots: The Last Wish",
            duration = "",
            rating = "1M",
            date = "6 month ago"
        ),
        VideoModel(
            id = "6",
            description = "",
            sources = "https://www.youtube.com/watch?v=eoOaKN4qCKw",
            subtitle = "The Fast Saga",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1720436834347.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/vertical-carousel-tv-1717431474775.jpg",
            title = "FAST X | Final Trailer",
            duration = "",
            rating = "200K",
            date = "3 year ago"
        ),
        VideoModel(
            id = "7",
            description = "",
            sources = "https://www.youtube.com/watch?v=EXeTwQWrcwY",
            subtitle = "Rotten Tomatoes Classic Trailers",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/the-dark-knight-rises-pre-3x4-1684028768183.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/the-dark-knight-tv-1696338828687.jpg",
            title = "The Dark Knight (2008) Official Trailer",
            duration = "",
            rating = "6M",
            date = "9 month ago"
        ),
        VideoModel(
            id = "8",
            description = "",
            sources = "https://www.youtube.com/watch?v=hebWYacbdvc",
            subtitle = "Warner Bros. Pictures",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/flash-3x4-lang-1711431077214.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/flash-tv-1699991069563.jpg",
            title = "The Flash ",
            duration = "",
            rating = "9M",
            date = "1 month ago"
        ),
        VideoModel(
            id = "9",
            description = "",
            sources = "https://www.youtube.com/watch?v=0ucTl-cxIjc",
            subtitle = "Well Go USA Entertainment",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1723187283942.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/vertical-tv-1723182567870.jpg",
            title = "CREATION OF THE GODS",
            duration = "",
            rating = "300M",
            date = "4 year ago"
        ),
        VideoModel(
            id = "10",
            description = "",
            sources = "https://www.youtube.com/watch?v=2OPOGUUkauc",
            subtitle = "Scene City",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1703676311201.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/vertical-carousel-tv-1703659873046.jpg",
            title = "Spider-Man 2",
            duration = "",
            rating = "24M",
            date = "1 year ago"
        ),
        VideoModel(
            id = "11",
            description = "",
            sources = "https://www.youtube.com/watch?v=otNh9bTjXWg",
            subtitle = "Warner Bros. Pictures",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1717935204380.jpg",
            thumbL = "https://v3img.voot.com/resizeMedium,w_914,h_514/v3Storage/assets/vertical-carousel-tv-1714658980641.jpg",
            title = "WONKA | Official Trailer",
            duration = "",
            rating = "45M",
            date = "6 month ago"
        )
    )

    val localData = listOf(
        VideoModel(
            id = "1",
            description = "Bumblebee",
            sources = getLocalFilePathFor("1.mp4"),
            subtitle = "Paramount Pictures",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/bumblebee-language-3x4-1704698849437.jpg",
            title = "Bumblebee",
            duration = "9 min 56 s",
            rating = "4"
        ),
        VideoModel(
            id = "2",
            description = "The first Blender Open Movie from 2006",
            sources = getLocalFilePathFor("2.mp4"),
            subtitle = "20th Century Studios",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/deadwood-themovie-3x4-1691555895191.jpg",
            title = "Deadpool 2",
            duration = "10 min 53 s",
            rating = "5"
        ),
        VideoModel(
            id = "3",
            description = "HBO GO now works with Chromecast -- the easiest way to enjoy online video on your TV.",
            sources = getLocalFilePathFor( "3.mp4") ,
            subtitle = "Movies",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1723143075888.jpg",
            title = "Incredibles 2",
            duration = "14 s",
            rating = "4.5"
        ),
        VideoModel(
            id = "4",
            description = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for when Batman's escapes aren't quite big enough. ",
            sources = getLocalFilePathFor( "4.mp4") ,
            subtitle = "Marvel Entertainment",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/justice-league-warworld-3x4-1697367402693.jpg",
            title = "Avengers: Infinity War",
            duration = "15 s",
            rating = "3"
        ),
        VideoModel(
            id = "5",
            description = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV. For $35.  Find out more at google.com/chromecast.",
            sources =  getLocalFilePathFor( "5.mp4") ,
            subtitle = "Rotten Tomatoes Trailers",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1708145297782.jpg",
            title = "Sinister",
            duration = "1 min",
            rating = "5"
        ),
        VideoModel(
            id = "6",
            description = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for the times that call for bigger joyrides. For $35. Learn how to use Chromecast with YouTube and more at google.com/chromecast.",
            sources =  getLocalFilePathFor( "6.mp4") ,
            subtitle = "By Google",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/hangover_3x4-1686200517765.jpg",
            title = "The Giver",
            duration = "15 s",
            rating = "4"
        ),
        VideoModel(
            id = "7",
            description ="Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for when you want to make Buster's big meltdowns even bigger. For $35. Learn how to use Chromecast with Netflix and more at google.com/chromecast.",
            sources =  getLocalFilePathFor( "7.mp4") ,
            subtitle = "The Lion King",
            thumb = "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/the-pride-kingdom-3x4-1674589010518.jpg",
            title = "Walt Disney Studios",
            duration = "15 s",
            rating = "4"
        )
    )

    val liveStreamData = listOf(
        VideoModel(
            id = "1",
            description = "",
            sources = "https://streams2.sofast.tv/ptnr-yupptv/title-THE-EXPLORERS-ENG_yupptv/v1/manifest/611d79b11b77e2f571934fd80ca1413453772ac7/4804aca3-dd54-43d1-8caa-0b836a76d9e9/2c13f493-2fa0-4b40-b7e0-1f980ec24e87/1.m3u8",
            subtitle = "",
            thumb = "https://d229kpbsb5jevy.cloudfront.net/yuppfast/content/common/logos/channel/logos/ggdzvt.png",
            title = "The Explorers"
        ),
        VideoModel(
            id = "2",
            description = "",
            sources = "https://streams2.sofast.tv/ptnr-yupptv/title-SCIFI-WORLD-ENG_yupptv/v1/manifest/611d79b11b77e2f571934fd80ca1413453772ac7/a985e052-6868-4365-ac45-52afe9008b25/9710f472-a853-404d-9437-a14fad18e013/1.m3u8",
            subtitle = "",
            thumb = "https://d229kpbsb5jevy.cloudfront.net/yuppfast/content/common/logos/channel/logos/oxsgsi.png",
            title = "Scifi World"
        ),
        VideoModel(
            id = "3",
            description = "",
            sources = "https://streams2.sofast.tv/ptnr-yupptv/title-HERITAGE-ENG_yuppfast/v1/manifest/611d79b11b77e2f571934fd80ca1413453772ac7/e4523706-f2a8-4b0f-b081-40fe59a46f81/29d25823-2c21-4977-83d5-84833e7329b7/1.m3u8",
            subtitle = "",
            thumb = "https://d229kpbsb5jevy.cloudfront.net/yuppfast/content/common/logos/channel/logos/fndjia.png",
            title = "Heritage"
        ),
        VideoModel(
            id = "4",
            description = "",
            sources = "https://streams2.sofast.tv/ptnr-yupptv/title-KIDDO-ENG_yupptv/v1/manifest/611d79b11b77e2f571934fd80ca1413453772ac7/5bcf9d24-04f2-401d-a93f-7af54f29461a/f270d3f1-98e5-47aa-90a6-8c3db345a633/1.m3u8",
            subtitle = "",
            thumb = "https://d229kpbsb5jevy.cloudfront.net/yuppfast/content/common/logos/channel/logos/kiddo.png",
            title = "Kiddo"
        ),
        VideoModel(
            id = "5",
            description = "",
            sources = "https://streams2.sofast.tv/ptnr-yupptv/title-FIGHT-TV-ENG_yupptv/v1/manifest/611d79b11b77e2f571934fd80ca1413453772ac7/70e45fc8-1f6c-4492-ac26-9868f70f4e02/3abecc3d-6e98-467e-adf1-2ed7e62ba84a/1.m3u8",
            subtitle = "",
            thumb = "https://d229kpbsb5jevy.cloudfront.net/yuppfast/content/common/logos/channel/logos/fight-tv.png",
            title = "Fight TV"
        )
    ).reversed()


    fun getFilteredData(data: List<VideoModel>, selectedVideo: VideoModel): List<VideoModel> {
        return data.filter { video ->
            video.title != selectedVideo.title
        }.shuffled()
    }
    fun topBannerData(): List<VideoModel> {
        return mockData.take(10).shuffled().take(5)
    }

    fun hotRightNow(): List<String> {
        return  listOf(
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1714876334737.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1701344922573.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1714658836206.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1715004079173.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/omg-2-3x4-1715057980908.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/language-3x4-1713425519873.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/dhak-dhak-3x4-1713933165718.jpg"
        ).shuffled()
    }
    fun machoMix(): List<String> {
        return  listOf(
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1715027895266.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/singham-3x4-1699008043276.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/vikram_vedha_3x4-1713964159968.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/singham-returns-1678889360141.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/dishoom-3x4-1705489569386.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1711200427872.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/bloody_daddy_3x4-1689152042847.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/jioimage/13/5/daad0dd074f611e688d58522ba040c22_1592564179458_p.jpg"
        ).shuffled()
    }

    fun popularInKids(): List<String> {
        return  listOf(
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/taffy3_4-1714390857784.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/chikoo-1713171980545.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/korra-1712231962670.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/golmaal-1713172138405.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/avatar3_4-1711631127914.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/pokemon-1704702227097.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/newseason3_4-1714503864626.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/rudra3_4-1714840929249.jpg",
        ).shuffled()
    }

    fun actionAdventure(): List<String> {
        return  listOf(
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1701247349405.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1707999938895.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4tiger-1714669567081.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/language-3x4-1713425519873.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/fast-x-call-out-3x4-1700301916853.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4warrior-1714669489518.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1712060324958.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1714658836206.jpg",
        ).shuffled()
    }

    fun hollywoodFinest(): List<String> {
        return  listOf(
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/fast-x-call-out-3x4-1700301916853.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/oppenheimer-3x4-1712046716651.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/microsoftteams-image-1684218552593.png",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/migration-3x4-1714129702879.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1714658836206.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/flash-3x4-lang-1711431077214.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/meg2lang3x4-1704254043974.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/fnf-3x4-1706942972580.jpg"
        ).shuffled()
    }

    fun southDubbed(): List<String> {
        return  listOf(
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/fast-x-call-out-3x4-1700301916853.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/oppenheimer-3x4-1712046716651.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/microsoftteams-image-1684218552593.png",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/migration-3x4-1714129702879.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1714658836206.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/flash-3x4-lang-1711431077214.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/meg2lang3x4-1704254043974.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/fnf-3x4-1706942972580.jpg"
        ).shuffled()
    }

    fun globalHits(): List<String> {
        return  listOf(
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/oppenheimer-3x4-1712046716651.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1714582063565.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1714658836206.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1712060324958.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/01-3x4-1711953148174.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/fast-x-call-out-3x4-1700301916853.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/language-3x4-1713423739488.jpg",
            "https://v3img.voot.com/resizeMedium,w_384,h_512/v3Storage/assets/3x4-1701247349405.jpg"
        ).shuffled()
    }
}