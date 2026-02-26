# Cultural Architecture Explorer
In this project, we colaborate with Badan Warisan Malaysia (BWM), to develop a website that integrated with AI chatbox. This website is a blog-like website that describes the historical architectual elements of Rumah Penghulu Abu Seman. 

## 🚀 Tech Stack

* **Framework:** React (via [Vite](vite.config.js))
* **Routing:** React Router (configured for SPA with Vercel via `vercel.json` and `public/_redirects`)
* **Linting:** ESLint ([eslint.config.js](eslint.config.js))
* **Deployment:** Vercel

## 📁 Project Structure

The workspace is organized as follows:

* **`src/components/`**: Contains reusable UI elements like the `Header`, `Footer`, and an interactive `Chatbox` feature.
* **`src/pages/`**: Contains the main views of the application:
  * `Homepage` - The main landing page.
  * `BalaiPage`, `DapurPage`, `RumahIbuPage`, `SelangPage` - Detailed explorations of specific architectural sections.
  * `OrnamentPage`, `IkatPage` - Information on traditional decorations and tying techniques.
  * `ClimatePage` - Details on how the architecture adapts to the local climate.
  * `QuizPage` - An interactive quiz to test the user's knowledge.
  * `CategoryPage` - Browsing interface for different topics.

## 🛠️ Getting Started

### Prerequisites

Make sure you have [Node.js](https://nodejs.org/) installed on your machine.

### Installation

1. Clone the repository.
2. Install the dependencies:

```sh
npm install
```
## Demo 
<video controls src="20260226-0639-41.7507300.mp4" title="Demo Video"></video>
### Running Locally

To start the Vite development server, run:

```sh
npm run dev
```

Open your browser and navigate to the local URL provided in the terminal (usually `http://localhost:5173`).

### Building for Production

To create a production-ready build, run:

```sh
npm run build
```

The compiled assets will be generated in the `dist` folder.

## 🌍 Deployment

This project is configured for seamless deployment on Vercel, utilizing the [vercel.json](vercel.json) configuration file. 

For detailed deployment instructions, please refer to the [DEPLOYMENT_GUIDE.md](DEPLOYMENT_GUIDE.md).