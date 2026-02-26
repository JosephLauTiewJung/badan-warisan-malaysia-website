const Header = () => {
    return (
        <div className="flex h-16 items-center bg-white mt-8">
            <div className="flex items-center border-r border-dashed border-blue-400 px-6 py-4">

                <button className="mr-4 text-gray-800">
                    <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6" fill="none" viewBox="0 0 24 24"
                         stroke="currentColor" stroke-width="3">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M15 19l-7-7 7-7"/>
                    </svg>
                </button>

                <span className="text-xl font-medium tracking-widest text-gray-700 uppercase">
      Exhibit Directory
    </span>

            </div>
        </div>
    )
}

export default Header;