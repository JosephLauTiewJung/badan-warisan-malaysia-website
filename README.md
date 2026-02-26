# Cultural Architecture Explorer
In this project, we colaborate with Badan Warisan Malaysia (BWM), to develop a website that integrated with AI chatbox. This website is a blog-like website that describes the historical architectual elements of Rumah Penghulu Abu Seman. 

## 🚀 Tech Stack

* **Framework:** React (via [Vite](vite.config.js))
* **AI Model:** GEMINI API
* **Database:** Qdrant vector database 
* **Backend:** Spring-boot, SpringAI
* **Linting:** ESLint ([eslint.config.js](eslint.config.js))
* **Deployment:** Vercel

## 📁 Project Structure

The workspace is organized as follows:

## Project Structure

- [backend/](backend/) — Java backend service
  - [backend/pom.xml](backend/pom.xml)
  - [backend/src/main/java/](backend/src/main/java/)
  - [backend/src/main/resources/](backend/src/main/resources/)
  - [backend/src/test/java/](backend/src/test/java/)
- [frontend/](frontend/) — React frontend
  - [frontend/package.json](frontend/package.json)
  - [frontend/src/App.jsx](frontend/src/App.jsx)
  - [frontend/src/main.jsx](frontend/src/main.jsx)
  - [frontend/src/components/](frontend/src/components/)
  - [frontend/src/pages/](frontend/src/pages/)
- [.gitignore](.gitignore)

## 🛠️ Getting Started

### Prerequisites
- **Node.js** 18+ and npm
- **Java** 17+ (or version required by [backend/pom.xml](backend/pom.xml))
- Maven (or use [backend/mvnw](backend/mvnw) / [backend/mvnw.cmd](backend/mvnw.cmd))

### Installation

1. Clone the repository.
2. Install the dependencies:

## Demo 
* Please refer to the youtube link below 
https://youtu.be/bM5PHjzR0mE

### Running Locally

### 1) Backend

From [backend/](backend/):

- Windows:
  `mvnw.cmd spring-boot:run`
- macOS/Linux:
  `./mvnw spring-boot:run`

Or with Maven installed:
`mvn spring-boot:run`


### 2) Frontend

From [frontend/](frontend/):

1. Install dependencies: `npm install`
2. Start dev server: `npm run dev`

## Environment Variables 
- Create local env files as needed:
  - `frontend/.env.local`
  - `backend/.env` (if used)
- Keep secrets out of source control (see [.gitignore](.gitignore)).